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
		param.put("pageNumber",(pageNum==null)?1:Integer.parseInt(pageNum));
		if(request.getParameter("search_option")!=null) {
			param.put("column", String.valueOf(request.getParameter("search_option")));
			param.put("searchWord", String.valueOf(request.getParameter("search_word")));
			param.put("countRow",MemberServiceImpl.getInstance().count(param));
		} else {
			param.put("countRow",MemberServiceImpl.getInstance().count());
		}
		pxy.carryOut(param);
		Pagination page = pxy.getPagination();
		String[] arr1 = {"domain", "beginRow", "endRow"};
		String[] arr2 = {request.getServletPath()
				.split("/")[1]
				.split("\\.")[0],
			String.valueOf(page.getBeginRow()),
			String.valueOf(page.getEndRow()),
		};
		for(int i = 0; i < arr1.length; i++){
			param.put(arr1[i],arr2[i]);
		};
		request.setAttribute("searchOption", param.get("column"));
		request.setAttribute("searchWord", param.get("searchWord"));
		request.setAttribute("member",MemberServiceImpl.getInstance().search(param));
		request.setAttribute("page",page);
		super.execute();
	}
}
