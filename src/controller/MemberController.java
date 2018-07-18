package controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.*;
import domain.*;
import service.*;
import enums.*;

@WebServlet({ "/member.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Sentry.init(request);
		System.out.println("액션: "+Sentry.cmd.getAction());
		MemberBean mem = null;
		List<MemberBean> lst = null;
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE:
			try {
				System.out.println("무브 안으로 진입");
				Carrier.send(request, response);
			} catch (Exception e) {	e.printStackTrace();}
			break;
		case JOIN:
			mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			mem.setName(request.getParameter("name"));
			mem.setSsn(request.getParameter("ssn"));
			MemberServiceImpl.getInstance().createMember(mem);
			response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=login_form");
			break;
		case LIST:
			lst = new ArrayList<>();
			lst = MemberServiceImpl.getInstance().listMember();
			response.sendRedirect(request.getContextPath());
			break;
		case RETRIEVE:
			lst = new ArrayList<>();
			lst = MemberServiceImpl.getInstance().findMemberByWord(request.getParameter("team_name"));
			response.sendRedirect(request.getContextPath());
			break;
		case SEARCH:
			mem = new MemberBean();
			mem = MemberServiceImpl.getInstance().findMemberBySeq(request.getParameter("memid"));
			response.sendRedirect(request.getContextPath());
			break;
		case COUNT:
			int count = MemberServiceImpl.getInstance().countMember();
			break;
		case UPDATE:
			mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("old_password")+"/"+request.getParameter("new_password"));
			MemberServiceImpl.getInstance().modifyMember(mem);
			response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=mypage");
			break;
		case DELETE:
			mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			MemberServiceImpl.getInstance().removeMember(mem);
			response.sendRedirect(request.getContextPath());
			break;
		case LOGIN:
			mem = new MemberBean();
			mem.setTeamId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			MemberServiceImpl.getInstance().login(mem);
			response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=mypage");
			System.out.println(mem.toString());
			break;
		default:
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
