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
		Receiver.init(request);
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case ADD:
			Carrier.redirect(request, response,"/member.do?action=move&page=main");
			break;
		case SEARCH: case RETRIEVE:
			Carrier.forword(request, response);
			break;
		case COUNT:
			Carrier.redirect(request, response, "");
			break;
		case MODIFY:
			Receiver.cmd.setPage("login_form");
			Receiver.cmd.execute();
			Carrier.forword(request, response);
			break;
		case REMOVE:
			Carrier.redirect(request, response,"");
			break;
		case MOVE:
			Carrier.forword(request, response);
			break;
		case LOGIN:
			if(request.getAttribute("match").equals("TRUE")) {
				System.out.println("로그인성공");
				Carrier.forword(request, response);
			}else {
				System.out.println("로그인실패");
				Carrier.redirect(request,  response, "/member.do?action=move&page=login" );
			}
			break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}
	}
}
