package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
		System.out.println("retrieve 커맨드 진입");
		request.getSession().setAttribute("member", MemberServiceImpl.getInstance().retrieve(request.getParameter("userid")));
		request.setAttribute("pagename", request.getParameter("page"));
		if(ImageServiceImpl.getInstance().read(((MemberBean) request.getSession().getAttribute("member")).getUserId())!=null) {
			request.setAttribute("profile", "upload/"+ImageServiceImpl.getInstance().read(((MemberBean) request.getSession().getAttribute("member")).getUserId()).getImgName() +"." + ImageServiceImpl.getInstance().read(((MemberBean) request.getSession().getAttribute("member")).getUserId()).getExtension());
		}
		super.execute();
	}
}
