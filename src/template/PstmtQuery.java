package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate{
	@Override
	void initialize() {
	if(map.get("beginRow")==null&&map.get("userid")==null) {
			map.put("sql", String.format(
					" select " +
					ColumnFinder.find(Domain.MEMBER)
					+" FROM %s"
					+" WHERE %s "
					+" LIKE ? "
					, map.get("table"),map.get("column")));
		} else if(map.get("userid")!=null) {
			map.put("sql",
					"  INSERT INTO member   " + 
					"   (USERID, NAME, PASSWORD, SSN, AGE, ROLL, GENDER, TEAMID)  " +
					"   VALUES    "+
					"    ( ?, ?, ?, ?, ?, ?, ?, ? )   "
					);
		} else {
			map.put("sql", (
					"  SELECT T.*  "+ 
					"	FROM (SELECT ROWNUM RNUM, m.*  " + 
					"      FROM member m   " + 
					"      ORDER BY RNUM DESC) T   " + 
					"   WHERE T.RNUM BETWEEN  ?  AND  ?  "
					));
		}
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection()
					.prepareStatement((String)map.get("sql"));
			if(map.get("sql").toString().contains("LIKE")) {
				pstmt.setString(1, "%"+map.get("value").toString()+"%");
			}else if(map.get("sql").toString().contains("INSERT")) {
				pstmt.setString(1, (String) map.get("userid").toString());
				pstmt.setString(2, (String) map.get("name").toString());
				pstmt.setString(3, (String) map.get("password"));
				pstmt.setString(4, (String) map.get("ssn").toString());
				pstmt.setString(5, (String) map.get("age").toString());
				pstmt.setString(6, (String) map.get("roll").toString());
				pstmt.setString(7, (String) map.get("gender").toString());
				pstmt.setString(8, (String) map.get("teamid").toString());
			} else {
				pstmt.setString(1, (String) map.get("beginRow").toString());
				pstmt.setString(2, (String) map.get("endRow").toString());
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserId(rs.getString("USERID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setAge(rs.getString("AGE"));
				mem.setGender(rs.getString("GENDER"));
				list.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
