package command;
import java.util.HashMap;
import java.util.Map;

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
			Map<Object,String> map = new HashMap<>();
			map.put("userid", ((MemberBean)request.getSession().getAttribute("user")).getUserId());
			map.put("password", (request.getParameter("password")));
			map.put("teamid", (request.getParameter("teamid")));
			map.put("roll", (request.getParameter("roll")));
			MemberServiceImpl.getInstance().modify(map);
			request.setAttribute("update", MemberServiceImpl.getInstance().retrieve(map.get("userid")));
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
