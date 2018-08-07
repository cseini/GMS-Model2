package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate{
	@Override
	void initialize() {
		if(map.get("beginRow")==null) {
			map.put("sql", String.format(
					" select " +
					ColumnFinder.find(Domain.MEMBER)
					+" FROM %s"
					+" WHERE %s "
					+" LIKE ? "
					, map.get("table"),map.get("column")));
		} else {
			map.put("sql", (
					"  SELECT T.*  "+ 
					"	FROM (SELECT ROWNUM RNUM, m.*  " + 
					"      FROM member m   " + 
					"      ORDER BY RNUM DESC) T   " + 
					"   WHERE T.RNUM BETWEEN  ?  AND  ?  "));
		}
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection()
					.prepareStatement((String)map.get("sql"));
			if(map.get("sql").toString().contains("LIKE")) {
				pstmt.setString(1, "%"+map.get("value").toString()+"%");
			}else {
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
