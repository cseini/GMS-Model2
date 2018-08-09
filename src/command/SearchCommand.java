package command;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import proxy.PageProxy;
import proxy.Pagination;
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
		String pageNum = request.getParameter("pageNumber");
		String searchOption = request.getParameter("search_option");
		String searchWord = request.getParameter("search_word");
		Map<String,Object> param=new HashMap<>();
		PageProxy pxy = new PageProxy();
		pxy.carryOut((pageNum==null)?1:Integer.parseInt(pageNum));
		Pagination page = pxy.getPagination();
		param.put("searchOption", searchOption);
		param.put("searchWord", searchWord);
		param.put("beginRow", page.getBeginRow());
		param.put("endRow", page.getEndRow());
		request.setAttribute("list",MemberServiceImpl.getInstance().search(param));
		request.setAttribute("page",page);
		super.execute();
	}
}
