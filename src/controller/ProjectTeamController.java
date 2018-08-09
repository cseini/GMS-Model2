package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import enums.Action;

@WebServlet("/projectTeam.do")
public class ProjectTeamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request);
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE:
			Carrier.forword(request, response);
			break;
		case ADD:
			Carrier.redirect(request, response,"");
			break;
		case SEARCH:
			Carrier.redirect(request, response,"");
			break;
		case RETRIEVE:
			Carrier.redirect(request, response,"");
			break;
		case MODIFY:
			Carrier.redirect(request, response,"");
			break;
		case REMOVE:
			Carrier.redirect(request, response,"");
			break;
		default:
			break;
		}
	}
}
