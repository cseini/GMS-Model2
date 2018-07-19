package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import domain.ProjectTeamBean;
import enums.Domain;
import service.MemberServiceImpl;
import service.ProjectTeamServiceImpl;

public class DeleteCommand extends Command{
	public DeleteCommand(HttpServletRequest request) {
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
			System.out.println("회원탈퇴 들어옴");
			MemberBean mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			MemberServiceImpl.getInstance().removeMember(mem);
			System.out.println("회원탈퇴 성공");
			break;
		case PROJECTTEAM:
			System.out.println("팀삭제 들어옴");
			ProjectTeamBean team = new ProjectTeamBean();
			team.setTeamId(request.getParameter("team_id"));
			team.setTeamName(request.getParameter("team_name"));
			ProjectTeamServiceImpl.getInstance().removeProjectTeam(team);
			System.out.println("팀삭제 성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}
