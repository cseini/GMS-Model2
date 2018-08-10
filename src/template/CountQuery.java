package template;

import java.sql.ResultSet;
import java.sql.SQLException;
import enums.MemberSQL;
import factory.DatabaseFactory;

public class CountQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", MemberSQL.COUNT.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection()
					.prepareStatement((String) map.get("sql"));
		} catch (SQLException e) {
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
