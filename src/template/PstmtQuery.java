package template;

import java.sql.ResultSet;
import domain.MemberBean;
import factory.DatabaseFactory;
import enums.*;


public class PstmtQuery extends QueryTemplate{
	@Override
	void initialize() {
		String sql="";
		switch (Action.valueOf((String) map.get("flag"))) {
		case ADD:
			sql = MemberSQL.INSERT.toString();
			break;
		case SEARCH:
			if(map.get("searchOption")==null) {
				sql = MemberSQL.LIST.toString();		
			}else {
				sql = String.format(MemberSQL.SEARCH.toString(), map.get("searchOption"));
			}
			break;
		case RETRIEVE:
			sql = MemberSQL.RETRIEVE.toString();
			break;
		case COUNT:
			sql = MemberSQL.COUNT.toString();
			break;
		case REMOVE:
			sql = MemberSQL.DELETE.toString();
			break;
		case LOGIN:
			sql = MemberSQL.LOGIN.toString();
			break;
		default:
			break;
		}
		map.put("sql", sql);
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection()
					.prepareStatement((String)map.get("sql"));
			switch (Action.valueOf((String) map.get("flag"))) {
			case ADD:
					pstmt.setString(1, (String) map.get("userid").toString());
					pstmt.setString(2, (String) map.get("teamid").toString());
					pstmt.setString(3, (String) map.get("name").toString());
					pstmt.setString(4, (String) map.get("ssn").toString());
					pstmt.setString(5, (String) map.get("roll").toString());
					pstmt.setString(6, (String) map.get("pass").toString());
					pstmt.setString(7, (String) map.get("subject").toString());
					pstmt.setString(8, (String) map.get("age").toString());
					pstmt.setString(9, (String) map.get("gender").toString());
				break;
			case SEARCH:
				if(map.get("searchOption")==null) {
					pstmt.setString(1, map.get("beginRow").toString());
					pstmt.setString(2, map.get("endRow").toString());		
				}else {
					pstmt.setString(1, "%"+map.get("searchWord").toString()+"%");
					pstmt.setString(2, map.get("beginRow").toString());
					pstmt.setString(3, map.get("endRow").toString());		
				}
				break;
			case RETRIEVE:
				pstmt.setString(1, map.get("userid").toString());
				break;
			case REMOVE:
				pstmt.setString(1, map.get("userid").toString());
				pstmt.setString(2, map.get("password").toString());				break;
			case LOGIN:
				pstmt.setString(1, map.get("userid").toString());
				pstmt.setString(2, map.get("password").toString());
				break;
			default:
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = null;
			MemberBean mem = null;
			switch (Action.valueOf((String) map.get("flag"))) {
			case ADD: case MODIFY: case REMOVE:
				rs = pstmt.executeQuery();
				break;
			case SEARCH: case RETRIEVE:
				rs = pstmt.executeQuery();
				while(rs.next()) {
					mem = new MemberBean();
					mem.setUserId(rs.getString("USERID"));
					mem.setTeamId(rs.getString("TEAMID"));
					mem.setName(rs.getString("NAME"));
					mem.setSsn(rs.getString("SSN"));
					mem.setRoll(rs.getString("ROLL"));
					mem.setPassword(rs.getString("PASSWORD"));
					mem.setSubject(rs.getString("SUBJECT"));
					mem.setAge(rs.getString("AGE"));
					mem.setGender(rs.getString("GENDER"));
					list.add(mem);
				}
				break;
			case COUNT:
				rs = pstmt.executeQuery();
				while(rs.next()) {
					list.add(rs.getInt("count"));
				}
				break;
			case LOGIN:
				rs = pstmt.executeQuery();
				while(rs.next()) {
					mem = new MemberBean();
					mem.setUserId(rs.getString("userid"));
					list.add(mem);	
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
