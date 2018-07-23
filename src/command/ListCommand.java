package command;

import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import service.MemberServiceImpl;

public class ListCommand extends Command{
	public ListCommand(HttpServletRequest request) {
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
			System.out.println("리스트진입");
			request.setAttribute("memberList",MemberServiceImpl.getInstance().listMember());
			System.out.println("리스트출력성공");
			break;

		default:
			break;
		}
		super.execute();
	}
}
