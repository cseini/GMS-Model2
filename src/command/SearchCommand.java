package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
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
		switch (Domain.valueOf(getDomain().toUpperCase())) {
		case MEMBER:
			System.out.println("팀검색진입");
			List<MemberBean> lst = MemberServiceImpl.getInstance().findMemberByWord(request.getParameter("team_name"));
			System.out.println(lst.size());
			System.out.println("팀검색성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}
