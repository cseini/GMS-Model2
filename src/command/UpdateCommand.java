package command;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import domain.ProjectTeamBean;
import enums.Domain;
import service.MemberServiceImpl;
import service.ProjectTeamServiceImpl;

public class UpdateCommand extends Command{
	
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			MemberBean mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("old_password")+"/"+request.getParameter("new_password"));
			MemberServiceImpl.getInstance().modifyMember(mem);
			request.setAttribute("update", MemberServiceImpl.getInstance().findMemberBySeq(mem.getUserId()));
			System.out.println(MemberServiceImpl.getInstance().findMemberBySeq(mem.getUserId()).toString());
			break;
		case PROJECTTEAM:
			ProjectTeamBean team = new ProjectTeamBean();
			team.setTeamId(request.getParameter("teamid"));
			team.setTeamName(request.getParameter("old_teamname")+"/"+request.getParameter("new_teamname"));
			ProjectTeamServiceImpl.getInstance().modifyProjectTeam(team);
			break;
		default:
			break;
		}
		super.execute();
	}
}
