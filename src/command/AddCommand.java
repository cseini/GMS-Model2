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
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			MemberBean mem = new MemberBean();
			if(MemberServiceImpl.getInstance().retrieve(request.getParameter("userid"))!=null) {
				System.out.println("아이디 중복");
				break;
			} else {
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
			}
			break;
		default:
			break;
		}
		super.execute();
	}
	
}	
