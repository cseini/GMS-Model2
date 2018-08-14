package command;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		MemberBean mem = new MemberBean();
		mem.setUserId(request.getParameter("userid"));
		mem.setPassword(request.getParameter("password"));
		if(MemberServiceImpl.getInstance().login(mem)) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("member", MemberServiceImpl.getInstance().retrieve(request.getParameter("userid")));
			request.setAttribute("pagename", request.getParameter("page"));
			if(ImageServiceImpl.getInstance().read(((MemberBean) request.getSession().getAttribute("member")).getUserId())!=null) {
				request.getSession().setAttribute("profile", "upload/"+ImageServiceImpl.getInstance().read(((MemberBean) request.getSession().getAttribute("member")).getUserId()).getImgName() +"." + ImageServiceImpl.getInstance().read(((MemberBean) request.getSession().getAttribute("member")).getUserId()).getExtension());
			}
		} else {
			request.setAttribute("match", "FALSE");
		}
	}
}
