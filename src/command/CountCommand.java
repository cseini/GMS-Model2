package command;

import javax.servlet.http.HttpServletRequest;
import service.MemberServiceImpl;

public class CountCommand extends Command{
	
	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
		@Override
		public void execute() {
			request.setAttribute("count",MemberServiceImpl.getInstance().count());
			System.out.println("카운트 커맨드 진입");
			super.execute();
		}
}
	
