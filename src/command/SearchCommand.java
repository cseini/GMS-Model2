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
		execute();
	}
	
	@Override
	public void execute() {
		String pageNum = request.getParameter("pageNumber");
		Map<String,Object> param=new HashMap<>();
		PageProxy pxy = new PageProxy();
		pxy.carryOut((pageNum==null)?1:Integer.parseInt(pageNum));
		Pagination page = pxy.getPagination();
		String[] arr1 = {"domain", "beginRow", "endRow", "searchWord"};
		String[] arr2 = {request.getServletPath()
				.split("/")[1]
				.split("\\.")[0],
			String.valueOf(page.getBeginRow()),
			String.valueOf(page.getEndRow()),
			String.valueOf(request.getParameter("search_word"))
		};
		for(int i = 0; i < arr1.length; i++){
			param.put(arr1[i],arr2[i]);
		};
		if(request.getParameter("search_option")!=null) {
			param.put("column", String.valueOf(request.getParameter("search_option")));
		}
		request.setAttribute("list",MemberServiceImpl.getInstance().search(param));
		request.setAttribute("page",page);
		super.execute();
	}
}
