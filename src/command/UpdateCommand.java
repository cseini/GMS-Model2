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
			mem.setPassword(request.getParameter("password"));
			mem.setTeamId(request.getParameter("teamid"));
			mem.setRoll(request.getParameter("roll"));
			MemberServiceImpl.getInstance().modifyMember(mem);
			request.setAttribute("update", MemberServiceImpl.getInstance().findMemberBySeq(mem.getUserId()));
			break;
		case PROJECTTEAM:
			ProjectTeamBean team = new ProjectTeamBean();
			ProjectTeamServiceImpl.getInstance().modifyProjectTeam(team);
			break;
		default:
			break;
		}
		super.execute();
	}
}
