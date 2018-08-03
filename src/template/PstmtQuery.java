package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate{
	@Override
	void initialize() {
		map.put("sql", String.format(
				" select " +
				ColumnFinder.find(Domain.MEMBER)
				+" FROM %s"
				+" WHERE %s "
				+" LIKE ? "
				, map.get("table"),map.get("column")));
	}

	@Override
	void startPlay() {
		System.out.println("=================");
		System.out.println(map.get("sql"));
		System.out.println(map.get("value"));
		String aa = "%" +map.get("value").toString()+"%";
		System.out.println("======"+aa+"=======");
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection()
					.prepareStatement((String)map.get("sql"));
			pstmt.setString(1, "%"+map.get("value").toString()+"%");
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
