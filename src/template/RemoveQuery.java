package template;

import enums.MemberSQL;

public class RemoveQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", MemberSQL.DELETE.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String) map.get("userid"));
			pstmt.setString(2, (String) map.get("pass"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			pstmt.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
