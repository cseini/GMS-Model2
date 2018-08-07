package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class PageProxy implements Proxy{
	HttpServletRequest request;
	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String, Object> map = new HashMap<>();
		request= (HttpServletRequest) param.get("request");
		request.setAttribute("count",MemberServiceImpl.getInstance().countMember());
		/*request.setAttribute("beginPage",beginPage);
		request.setAttribute("endPage",count/pageSize<pageSize+1?(count/pageSize==0?count/pageSize:count/pageSize+1):beginPage+(pageSize-1));
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);*/
		return map;
	}
	
}
