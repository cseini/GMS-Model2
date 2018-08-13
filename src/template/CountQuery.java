package template;

import java.sql.ResultSet;
import enums.MemberSQL;

public class CountQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", (!map.containsKey("column"))?
				MemberSQL.COUNT.toString()
				:String.format(MemberSQL.SEARCHCOUNT.toString(),map.get("column")));
	}

	@Override
	void startPlay() {
		try {
			if(map.get("sql").toString().contains("WHERE")) {
				pstmt.setString(1, "%"+map.get("searchWord").toString()+"%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				number = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
