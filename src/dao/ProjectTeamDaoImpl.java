package dao;

import java.util.ArrayList;
import java.util.List;

import domain.ProjectTeamBean;

public class ProjectTeamDaoImpl implements ProjectTeamDao{
	private static ProjectTeamDao instance = new ProjectTeamDaoImpl();
	public static ProjectTeamDao getInstance() {return instance;}
	private ProjectTeamDaoImpl() {}
	@Override
	public void insertProjectTeam(ProjectTeamBean ProjectTeam) {
		
	}
	@Override
	public List<ProjectTeamBean> selectAllProjectTeam() {
		List<ProjectTeamBean> lst = new ArrayList<>();
		
		return lst;
	}
	@Override
	public List<ProjectTeamBean> selectProjectTeamByWord(String word) {
		List<ProjectTeamBean> lst = new ArrayList<>();
		
		return lst;
	}
	@Override
	public ProjectTeamBean selectProjectTeamBySeq(String seq) {
		ProjectTeamBean team = null;
		
		return team;
	}
	
	@Override
	public int countProjectTeam() {
		int count = 0;
		
		return count;
	}
	@Override
	public void updateProjectTeam(ProjectTeamBean bean) {
			
	}
	@Override
	public void deleteProjectTeam(ProjectTeamBean bean) {
		
	}
}
