package template;

import enums.MemberSQL;

public class ModifyQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(MemberSQL.UPDATE.toString(), map.get("column")));
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String) map.get("value"));
			pstmt.setString(2, (String) map.get("userid"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
