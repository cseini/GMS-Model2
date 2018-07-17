package dao;
import java.util.List;

import domain.*;

public interface ProjectTeamDao {
	public void insertProjectTeam(ProjectTeamBean ProjectTeam);
	public List<ProjectTeamBean> selectAllProjectTeam();
	public List<ProjectTeamBean> selectProjectTeamByWord(String word);
	public ProjectTeamBean selectProjectTeamBySeq(String seq);
	public int countProjectTeam();
	public void updateProjectTeam(ProjectTeamBean bean);
	public void deleteProjectTeam(ProjectTeamBean bean);
}
