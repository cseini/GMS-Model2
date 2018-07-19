package command;
import javax.servlet.http.HttpServletRequest;

import com.sun.corba.se.impl.javax.rmi.PortableRemoteObject;

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
		switch (Domain.valueOf(getDomain().toUpperCase())) {
		case MEMBER:
			System.out.println("업데이트 진입");
			MemberBean mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("old_password")+"/"+request.getParameter("new_password"));
			MemberServiceImpl.getInstance().modifyMember(mem);
			System.out.println("업데이트 성공");
			break;
		case PROJECTTEAM:
			System.out.println("팀 업데이트 진입");
			ProjectTeamBean team = new ProjectTeamBean();
			team.setTeamId(request.getParameter("teamid"));
			team.setTeamName(request.getParameter("old_teamname")+"/"+request.getParameter("new_teamname"));
			ProjectTeamServiceImpl.getInstance().modifyProjectTeam(team);
			System.out.println("팀 업데이트 성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}
