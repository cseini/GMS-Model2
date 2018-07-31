package command;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("mypage");
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
			request.getSession().setAttribute("user", MemberServiceImpl.getInstance().findMemberBySeq(request.getParameter("userid")));
			System.out.println("로그인 성공!!!");
		} else {
			request.setAttribute("match", "FALSE");
			System.out.println("로그인 실패!!!");
		}
	}
}
