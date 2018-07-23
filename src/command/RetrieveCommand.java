package command;

import javax.servlet.http.HttpServletRequest;

import enums.Domain;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(HttpServletRequest request) {
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
			System.out.println("아이디검색들어옴");
			request.setAttribute("retrieve", MemberServiceImpl.getInstance().findMemberBySeq(request.getParameter("userid")));
			System.out.println("아이디검색성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}
