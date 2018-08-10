package template;

import java.sql.ResultSet;
import java.sql.SQLException;
import domain.MemberBean;
import enums.MemberSQL;

public class RetrieveQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberSQL.RETRIEVE.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String) map.get("userid"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		ResultSet rs=null;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				o = new MemberBean();
				((MemberBean) o).setUserId(rs.getString("USERID"));
				((MemberBean) o).setPassword(rs.getString("PASSWORD"));
				((MemberBean) o).setName(rs.getString("NAME"));
				((MemberBean) o).setSsn(rs.getString("SSN"));
				((MemberBean) o).setAge(rs.getString("AGE"));
				((MemberBean) o).setGender(rs.getString("GENDER"));
				((MemberBean) o).setTeamId(rs.getString("TEAMID"));
				((MemberBean) o).setRoll(rs.getString("ROLL"));
				((MemberBean) o).setSubject(rs.getString("SUBJECT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
