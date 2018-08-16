package command;

import javax.servlet.http.HttpServletRequest;
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
		request.setAttribute("pagename", request.getParameter("page"));
		if(request.getParameter("userid")==null) { /*여긴 로그인했을때*/
			request.setAttribute("profile", "upload/"+ImageServiceImpl.getInstance().read(((MemberBean) request.getSession().getAttribute("user")).getUserId()).getImgName() +"." + ImageServiceImpl.getInstance().read(((MemberBean) request.getSession().getAttribute("user")).getUserId()).getExtension());
		} else { /*서치에서 리트리브 진입할 때*/
			if(ImageServiceImpl.getInstance().read(request.getParameter("userid"))!=null){
				request.setAttribute("profile", "upload/"+ImageServiceImpl.getInstance().read(request.getParameter("userid")).getImgName() +"." + ImageServiceImpl.getInstance().read(request.getParameter("userid")).getExtension());				
				request.setAttribute("user",MemberServiceImpl.getInstance().retrieve(request.getParameter("userid")));
			} else {
				request.setAttribute("user",MemberServiceImpl.getInstance().retrieve(request.getParameter("userid")));
				request.setAttribute("profile", "upload/default.jpg");	
			}
		}
		super.execute();
	}
}
