package template;

import java.sql.ResultSet;
import domain.MemberBean;
import enums.MemberSQL;

public class LoginQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberSQL.LOGIN.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, map.get("userid").toString());
			pstmt.setString(2, map.get("pass").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				o = new MemberBean();
				((MemberBean) o).setUserId(rs.getString("USERID"));
				((MemberBean) o).setPassword(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
