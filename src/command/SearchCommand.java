package command;

import javax.servlet.http.HttpServletRequest;
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
		request.setAttribute("list", MemberServiceImpl.getInstance().findMemberByWord(request.getParameter("search_domain")+"/"+request.getParameter("search_option")+"/"+request.getParameter("search_word"))); 
		super.execute();
	}
}
