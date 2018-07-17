package service;
import java.util.List;

import domain.*;

public interface ProjectTeamService {
	public void createProjectTeam(ProjectTeamBean ProjectTeam);
	public List<ProjectTeamBean> listProjectTeam();
	public List<ProjectTeamBean> findProjectTeamByWord(String word);
	public ProjectTeamBean findProjectTeamBySeq(String seq);
	public int countProjectTeam();
	public void modifyProjectTeam(ProjectTeamBean bean);
	public void removeProjectTeam(ProjectTeamBean bean);
}
