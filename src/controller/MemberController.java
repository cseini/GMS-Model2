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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Sentry.init(request);
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE:
			System.out.println("MOVE");
			Carrier.forword(request, response);
			break;
		case JOIN:
			System.out.println("JOIN");
			Carrier.redirect(request, response,"/member.do?action=move&page=login_form");
			break;
		case LIST:
			System.out.println("LIST");
			Carrier.redirect(request, response, "");
			break;
		case SEARCH:
			System.out.println("SEARCH");
			Carrier.redirect(request, response, "");
			break;
		case RETRIEVE:
			System.out.println("RETRIEVE");
			Carrier.redirect(request, response, "");
			break;
		case COUNT:
			System.out.println("COUNT");
			Carrier.redirect(request, response, "");
			break;
		case UPDATE:
			System.out.println("UPDATE");
			Carrier.redirect(request, response, "/member.do?action=move&page=mypage");
			break;
		case DELETE:
			System.out.println("DELETE");
			Carrier.redirect(request, response,"");
			break;
		case LOGIN:
			System.out.println("LOGIN");
			Carrier.redirect(request, response, "/member.do?action=move&page=mypage");
			break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
