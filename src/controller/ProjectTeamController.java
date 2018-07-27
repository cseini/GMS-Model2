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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sentry.init(request);
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE:
			Carrier.forword(request, response);
			break;
		case CREATE:
			Carrier.redirect(request, response,"");
			break;
		case LIST:
			Carrier.redirect(request, response,"");
			break;
		case SEARCH:
			Carrier.redirect(request, response,"");
			break;
		case RETRIEVE:
			Carrier.redirect(request, response,"");
			break;
		case DELETE:
			Carrier.redirect(request, response,"");
			break;
		case UPDATE:
			Carrier.redirect(request, response,"");
			break;
		default:
			break;
		}
	}
}
