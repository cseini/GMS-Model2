package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import enums.Path;

@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	enum Resources{
		CONTEXT, CSS, JS, IMG
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0;
		for (Resources r : Resources.values()) {
			request.getSession().setAttribute(r.toString().toLowerCase(),
					(i==0)?
							request.getContextPath() : 
								request.getContextPath()
								+Path.RESOURCES.toString()
								+r.toString().toLowerCase());
            i++;
		}
		request.setAttribute("domain", request.getServletPath()
				.split("/")[1]
				.split("\\.")[0]);
		request.getRequestDispatcher(Path.WEBPATH.toString()
												+request.getServletPath()
													.split("/")[1]
													.split("\\.")[0]
												+Path.MAIN.toString()).forward(request, response);
	}
}