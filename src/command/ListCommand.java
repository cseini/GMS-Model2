package command;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;
public class ListCommand extends Command{
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		Map<String,Object> param=new HashMap<>();
		String pageNum = request.getParameter("pageNumber");
		String rowOption = request.getParameter("rowOption");
		PageProxy pxy = new PageProxy();
		/*pxy.carryOut((pageNum==null)?1:Integer.parseInt(pageNum));*/
		pxy.carryOut((pageNum==null)?1:Integer.parseInt(pageNum),(rowOption==null)?5:Integer.parseInt(request.getParameter("rowOption")));
		Pagination page = pxy.getPagination();
		param.put("beginRow", page.getBeginRow());
		param.put("endRow", page.getEndRow());
		request.setAttribute("list",MemberServiceImpl.getInstance().getList(param));
		request.setAttribute("page",page);
		super.execute();
	}
}
