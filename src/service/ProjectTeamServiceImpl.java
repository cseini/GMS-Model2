package service;

import java.util.List;

import dao.ProjectTeamDaoImpl;
import domain.ProjectTeamBean;

public class ProjectTeamServiceImpl implements ProjectTeamService{
	private static ProjectTeamService instance = new ProjectTeamServiceImpl();
	public static ProjectTeamService getInstance() {return instance;}
	private ProjectTeamServiceImpl() {}
	@Override
	public void createProjectTeam(ProjectTeamBean ProjectTeam) {
		ProjectTeamDaoImpl.getInstance().insertProjectTeam(ProjectTeam);
	}
	@Override
	public List<ProjectTeamBean> listProjectTeam() {
		return ProjectTeamDaoImpl.getInstance().selectAllProjectTeam();
	}
	@Override
	public List<ProjectTeamBean> findProjectTeamByWord(String word) {
		return ProjectTeamDaoImpl.getInstance().selectProjectTeamByWord(word);
	}
	@Override
	public ProjectTeamBean findProjectTeamBySeq(String seq) {
		return ProjectTeamDaoImpl.getInstance().selectProjectTeamBySeq(seq);
	}
	@Override
	public int countProjectTeam() {
		return ProjectTeamDaoImpl.getInstance().countProjectTeam();
	}
	@Override
	public void modifyProjectTeam(ProjectTeamBean bean) {
		ProjectTeamDaoImpl.getInstance().updateProjectTeam(bean);
	}
	@Override
	public void removeProjectTeam(ProjectTeamBean bean) {
		ProjectTeamDaoImpl.getInstance().deleteProjectTeam(bean);
	}

}
