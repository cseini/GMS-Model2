package template;

import java.sql.SQLException;
import enums.MemberSQL;

public class AddQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", MemberSQL.INSERT.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String) map.get("userid").toString());
			pstmt.setString(2, (String) map.get("pass").toString());
			pstmt.setString(3, (String) map.get("name").toString());
			pstmt.setString(4, (String) map.get("ssn").toString());
			pstmt.setString(5, (String) map.get("age").toString());
			pstmt.setString(6, (String) map.get("gender").toString());
			pstmt.setString(7, (String) map.get("teamid").toString());
			pstmt.setString(8, (String) map.get("roll").toString());
			pstmt.setString(9, (String) map.get("subject").toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		 try {
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
