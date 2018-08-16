package command;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ModifyCommand extends Command{
	
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			Map<Object,String> map = new HashMap<>();
			map.put("userid", ((MemberBean) request.getSession().getAttribute("user")).getUserId());
			String[] column = {"password","teamid","roll"};
			for(int i=0;i<column.length;i++) {
				if(!request.getParameter(column[i]).isEmpty()) {
					map.put("column", column[i]);
					map.put("value", request.getParameter(column[i]));
					MemberServiceImpl.getInstance().modify(map);
				}
			}
			request.getSession().setAttribute("user", MemberServiceImpl.getInstance().retrieve(map.get("userid")));
			break;
		default:
			break;
		}
		super.execute();
	}
}
