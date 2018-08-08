package command;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import domain.ProjectTeamBean;
import enums.Domain;
import service.MemberServiceImpl;
import service.ProjectTeamServiceImpl;

public class CreateCommand extends Command{
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("login_form");
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("회원가입에 들어옴!!!");
			MemberBean mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			mem.setName(request.getParameter("name"));
			mem.setSsn(request.getParameter("ssn"));
			mem.setAge(request.getParameter("age"));
			mem.setRoll(request.getParameter("roll"));
			mem.setGender(request.getParameter("gender"));
			mem.setTeamId(request.getParameter("teamid"));
			mem.setSubject(ParamMap.getValues(request, "subject"));
			MemberServiceImpl.getInstance().create(mem);
			System.out.println("회원가입 성공!!!");
			break;
		case PROJECTTEAM:
			System.out.println("팀 생성에 들어옴!!!");
			ProjectTeamBean team = new ProjectTeamBean();
			team.setTeamId(request.getParameter("team_id"));
			team.setTeamName(request.getParameter("team_name"));
			ProjectTeamServiceImpl.getInstance().createProjectTeam(team);
			System.out.println("팀생성 성공!!!");
			break;
		default:
			break;
		}
		super.execute();
	}
	
}	
