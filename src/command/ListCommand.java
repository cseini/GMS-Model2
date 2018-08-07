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
		String pageNum = request.getParameter("pageNumber");
		int pageNumber = 0;
		if(pageNum==null) {
			pageNumber=1;
		} else {
			pageNumber=Integer.parseInt(pageNum);
		}
		int count =MemberServiceImpl.getInstance().countMember();
		int pageSize=5;
		int blockSize=5;
		int beginRow = pageNumber*pageSize-(pageSize-1);
		int endRow = pageNumber*pageSize;
		int pageCount = count/pageSize==0?count/pageSize:count/pageSize+1;
		int blockCount = pageCount/blockSize==0?pageCount/blockSize:pageCount/blockSize+1;
		int beginPage= pageNumber-((pageNumber-1)%blockSize);
		int lastBlockPage=pageCount-((pageCount-1)%blockSize);
		int endPage=((lastBlockPage+pageSize)>pageNumber&&pageNumber>=lastBlockPage)?pageCount:beginPage+(pageSize-1);
		int prevBlock = beginPage - blockSize;
		int nextBlock = beginPage + blockSize;
		boolean existPrev=(prevBlock>=0);
		boolean existNext=(nextBlock<=pageCount);
		Map<String,Object> param=new HashMap<>();
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		request.setAttribute("count",count);
		request.setAttribute("beginPage",beginPage);
		request.setAttribute("endPage",endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);
		request.setAttribute("prevBlock", prevBlock);
		request.setAttribute("nextBlock", nextBlock);
		request.setAttribute("list",MemberServiceImpl.getInstance().getList(param));
		super.execute();
	}
}
