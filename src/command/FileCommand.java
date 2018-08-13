package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class FileCommand extends Command {

	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
		@Override
		public void execute() {
			request.setAttribute("pagename", request.getParameter("page"));
			request.setAttribute("member", MemberServiceImpl.getInstance().retrieve(request.getParameter("userid")));
			super.execute();
		}
}
	