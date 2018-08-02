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

@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Sentry.init(request);
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE:
			Carrier.forword(request, response);
			break;
		case LIST:
			Carrier.forword(request, response);
			break;
		case RETRIEVE:
			Carrier.forword(request, response);
			break;
		case SEARCH:
			Carrier.forword(request, response);
			break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}
	}
}
