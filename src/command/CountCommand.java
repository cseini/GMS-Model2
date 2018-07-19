package command;

import javax.servlet.http.HttpServletRequest;
import enums.Domain;
import service.MemberServiceImpl;

public class CountCommand extends Command{
	
	public CountCommand(HttpServletRequest request) {
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
				int count = MemberServiceImpl.getInstance().countMember();
				System.out.println(count);
				break;
			default:
				break;
			}
			super.execute();
		}
}
	