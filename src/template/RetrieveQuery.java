package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.ImageSQL;
import enums.MemberSQL;

public class RetrieveQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "MEMBER":
			map.put("sql", MemberSQL.RETRIEVE.toString());	
			break;
		case "IMAGE":
			map.put("sql", ImageSQL.READ.toString());
			break;
		default:
			break;
		}
		
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
			switch (map.get("table").toString()) {
			case "MEMBER":
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
				break;
			case "IMAGE":
				while(rs.next()) {
					o = new ImageBean();
					((ImageBean) o).setUserid(rs.getString("USERID"));
					((ImageBean) o).setImgName(rs.getString("IMG_NAME"));
					((ImageBean) o).setExtension(rs.getString("EXTENSION"));
				}
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
