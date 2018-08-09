package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import domain.ProjectTeamBean;
import enums.Domain;
import service.MemberServiceImpl;
import service.ProjectTeamServiceImpl;

public class RemoveCommand extends Command{
	public RemoveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			MemberBean mem = new MemberBean();
			mem.setUserId(((MemberBean)request.getSession().getAttribute("member")).getUserId());
			mem.setPassword(request.getParameter("password"));
			MemberServiceImpl.getInstance().remove(mem);
			request.getSession().invalidate();
			break;
		default:
			break;
		}
		super.execute();
	}
}
