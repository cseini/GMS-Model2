package command;

import java.util.HashMap;
import java.util.Map;

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
			Map<String, Object> map = new HashMap<>();
			if(request.getParameter("search_option")!=null) {
				map.put("searchOption",request.getParameter("search_option"));
				map.put("searchWord",request.getParameter("search_word"));
				request.setAttribute("count",MemberServiceImpl.getInstance().count(map));
			} else {
				request.setAttribute("count",MemberServiceImpl.getInstance().count());	
			}
			super.execute();
		}
}
	
