package command;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;

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
		if(pageNum==null) {
			pageNum="1";
		}
		int count =MemberServiceImpl.getInstance().countMember();
		int pageSize=5;
		int blockSize=5;
		int pageCount = count/pageSize==0?count/pageSize:count/pageSize+1;
		int blockCount = pageCount/blockSize==0?pageCount/blockSize:pageCount/blockSize+1;
		int beginPage= Integer.parseInt(pageNum)-((Integer.parseInt(pageNum)-1)%blockSize);
		int prevBlock = beginPage - blockSize;
		int nextBlock = beginPage + blockSize;
		boolean existPrev=false;
		if(prevBlock>=0) {
			existPrev =true;
		}
		boolean existNext=false;
		if(nextBlock<=pageCount) {
			existNext =true;
		}
		Map<String,Object> param=new HashMap<>();
		param.put("beginRow", Integer.parseInt(pageNum)*pageSize-(pageSize-1));
		param.put("endRow", Integer.parseInt(pageNum)*pageSize);
		request.setAttribute("count",count);
		request.setAttribute("beginPage",beginPage);
		request.setAttribute("endPage",count/pageSize<pageSize+1?(count/pageSize==0?count/pageSize:count/pageSize+1):beginPage+(pageSize-1));
		request.setAttribute("list",MemberServiceImpl.getInstance().getList(param));
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);
		super.execute();
	}
}
