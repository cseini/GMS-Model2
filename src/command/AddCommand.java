package command;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class AddCommand extends Command{
	public AddCommand(HttpServletRequest request) {
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
			mem.setSubject(request.getParameter("subject"));
			MemberServiceImpl.getInstance().add(mem);
			System.out.println("회원가입 성공!!!");
			break;
		default:
			break;
		}
		super.execute();
	}
	
}	
