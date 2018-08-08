package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.*;
import enums.*;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Sentry.init(request);
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE:
			Carrier.forword(request, response);
			break;
		case JOIN:
			Carrier.redirect(request, response,"/member.do?action=move&page=login_form");
			break;
		case LOGIN:
			if(request.getAttribute("match").equals("TRUE")) {
				System.out.println("로그인성공");
				Carrier.forword(request, response);
			}else {
				System.out.println("로그인실패");
				Carrier.redirect(request,  response, "/member.do?action=move&page=login_form" );
			}
			break;
		case SEARCH:
			Carrier.forword(request, response);
			break;
		case RETRIEVE:
			Carrier.forword(request, response);
			break;
		case COUNT:
			Carrier.redirect(request, response, "");
			break;
		case UPDATE:
			Sentry.cmd.setPage("login_form");
			Sentry.cmd.execute();
			Carrier.forword(request, response);
			break;
		case DELETE:
			Carrier.redirect(request, response,"");
			break;
		case LIST:
			Carrier.forword(request, response);
			break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}
	}
}
