package template;

import java.sql.ResultSet;
import java.sql.SQLException;
import domain.MemberBean;
import enums.MemberSQL;

public class SearchQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", (!map.containsKey("column")) ? 
				MemberSQL.LIST.toString()
				:String.format(MemberSQL.SEARCH.toString(),map.get("column")));
	}

	@Override
	void startPlay() {
		try {
			int j = 0;
			if(map.containsKey("column")) {
				j++;
				pstmt.setString(j, "%"+map.get("searchWord").toString()+"%");
			}
			j++;
			pstmt.setString(j, map.get("beginRow").toString());			
			j++;
			pstmt.setString(j, map.get("endRow").toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = null;
				while(rs.next()){
					mem = new MemberBean();
					mem.setUserId(rs.getString("USERID"));
					mem.setTeamId(rs.getString("TEAMID"));
					mem.setName(rs.getString("NAME"));
					mem.setAge(rs.getString("AGE"));
					mem.setGender(rs.getString("GENDER"));
					mem.setRoll(rs.getString("ROLL"));
					mem.setPassword(rs.getString("PASSWORD"));
					mem.setSsn(rs.getString("SSN"));
					list.add(mem);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
