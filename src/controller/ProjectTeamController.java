package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import enums.Action;

@WebServlet("/projectTeam.do")
public class ProjectTeamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sentry.init(request);
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE:
			Carrier.forword(request, response);
			break;
		case CREATE:
			System.out.println("JOIN");
			Carrier.redirect(request, response,"");
			break;
		case LIST:
			System.out.println("DELETE");
			Carrier.redirect(request, response,"");
			break;
		case SEARCH:
			System.out.println("UPDATE");
			Carrier.redirect(request, response,"");
			break;
		case RETRIEVE:
			System.out.println("RETRIEVE");
			Carrier.redirect(request, response,"");
			break;
		case DELETE:
			System.out.println("DELETE");
			Carrier.redirect(request, response,"");
			break;
		case UPDATE:
			System.out.println("UPDATE");
			Carrier.redirect(request, response,"");
			break;
		default:
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
