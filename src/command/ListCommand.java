package command;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
		/*request.setAttribute("count",MemberServiceImpl.getInstance().countMember());*/
		int count =MemberServiceImpl.getInstance().countMember();
		int page=1;
		int beginPage=1;
		String beginRow="1";
		String endRow ="5";
		Map<String,Object> param=new HashMap<>();
	/*	for(int i=1;i<(count/5==0?count/5:count/5+1);i++) {
			if(page==1) {
				beginRow="1";
				endRow="5";
			} else if(page==i) {
				beginRow=String.valueOf(Integer.parseInt("i")*i);
				endRow=String.valueOf(Integer.parseInt("i")*5);
			}
		}*/
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		request.setAttribute("count",count);
		request.setAttribute("beginPage",beginPage);
		request.setAttribute("endPage",count/5<6?(count/5==0?count/5:count/5+1):beginPage+4);
		/*다음 버튼 누르면 beginPage=beginPage+4*/
		/*request.setAttribute("list",MemberServiceImpl.getInstance().listMember());*/
		request.setAttribute("list",MemberServiceImpl.getInstance().getList(param));
		request.setAttribute("page", "5");
		super.execute();
	}
}
