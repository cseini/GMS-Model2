package command;

import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import service.MemberServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
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
			System.out.println("팀검색진입");
			request.setAttribute("search", MemberServiceImpl.getInstance().findMemberByWord(request.getParameter("team_name"))); 
			System.out.println("팀검색성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}
