package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import domain.ProjectTeamBean;
import enums.TeamQuery;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;

public class ProjectTeamDaoImpl implements ProjectTeamDao{
	private static ProjectTeamDao instance = new ProjectTeamDaoImpl();
	public static ProjectTeamDao getInstance() {return instance;}
	private ProjectTeamDaoImpl() {}
	@Override
	public void insertProjectTeam(ProjectTeamBean ProjectTeam) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(TeamQuery.INSERT_TEAM.toString(),ProjectTeam.getTeamId(),ProjectTeam.getTeamName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<ProjectTeamBean> selectAllProjectTeam() {
		List<ProjectTeamBean> lst = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(TeamQuery.TEAM_LIST.toString());
			ProjectTeamBean team = null;
			while(rs.next()) {
				team = new ProjectTeamBean();
				team.setTeamId(rs.getString("TEAM_ID"));
				team.setTeamName(rs.getString("TEAM_NAME"));
				lst.add(team);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	@Override
	public List<ProjectTeamBean> selectProjectTeamByWord(String word) {
		List<ProjectTeamBean> lst = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(String.format(TeamQuery.SEARCH_TEAMNAME.toString(),word));
			ProjectTeamBean team = null;
			while(rs.next()) {
				team = new ProjectTeamBean();
				team.setTeamId(rs.getString("TEAM_ID"));
				team.setTeamName(rs.getString("TEAM_NAME"));
				lst.add(team);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lst.get(0).getTeamName());
		return lst;
	}
	@Override
	public ProjectTeamBean selectProjectTeamBySeq(String seq) {
		ProjectTeamBean team = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery(String.format(TeamQuery.SEARCH_TEAMID.toString(),seq));
			while(rs.next()) {
				team = new ProjectTeamBean();
				team.setTeamId(rs.getString("TEAM_ID"));
				team.setTeamName(rs.getString("TEAM_NAME"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return team;
	}
	
	@Override
	public int countProjectTeam() {
		int count = 0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(TeamQuery.TEAM_COUNT.toString());
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public void updateProjectTeam(ProjectTeamBean bean) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(TeamQuery.UPDATE_NAME.toString(),bean.getTeamName().split("/")[1],bean.getTeamId(),bean.getTeamName().split("/")[0]));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bean.getTeamName().split("/")[1]);		
		System.out.println(bean.getTeamName().split("/")[0]);		
	}
	@Override
	public void deleteProjectTeam(ProjectTeamBean bean) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(TeamQuery.DELETE_TEAM.toString(),bean.getTeamId(),bean.getTeamName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
