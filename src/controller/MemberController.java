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
			if(request.getAttribute("idChecker").equals("TRUE")) {
				Carrier.redirect(request, response,"/member.do?action=move&page=login");
			}else {
				Carrier.redirect(request,  response, "/member.do?action=move&page=add" );
			}
			break;
		case SEARCH: case RETRIEVE:
			Carrier.forword(request, response);
			break;
		case COUNT:
			Carrier.redirect(request, response, "");
			break;
		case MODIFY: 
			Carrier.redirect(request, response,"/member.do?action=retrieve&page=retrieve");
			break;
		case FILEUPLOAD:
			Carrier.redirect(request, response,"/member.do?action=retrieve&page=retrieve");
			break;
		case REMOVE:
			Carrier.redirect(request, response,"");
			break;
		case MOVE:
			Carrier.forword(request, response);
			break;
		case LOGIN:
			if(request.getAttribute("match").equals("TRUE")) {
				Carrier.redirect(request, response, "/member.do?action=move&page=retrieve");
			}else {
				Carrier.redirect(request,  response, "/member.do?action=move&page=login" );
			}
			break;
		case LOGOUT:
			Carrier.redirect(request, response, "");
			break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}
	}
}
