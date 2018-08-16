package command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand extends Command{
	public LogoutCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		request.getSession().invalidate();
	}
}