package command;
import javax.servlet.http.HttpServletRequest;

import enums.*;

public class Commander{
	public static Command order(HttpServletRequest request) {
		Command cmd = null;
		switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			System.out.println("----무브진입----");
			cmd = new MoveCommand(request);
			break;
		case JOIN: case CREATE:
			System.out.println("----조인진입----");
			cmd = new CreateCommand(request);
			break;
		case LOGIN:
			System.out.println("----로그인진입----");
			cmd = new LoginCommand(request);
			break;
		case UPDATE:
			System.out.println("----업데이트진입----");
			cmd = new UpdateCommand(request);
			break;
		case SEARCH:
			System.out.println("----search진입----");
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE:
			System.out.println("----retrieve진입----");
			cmd = new RetrieveCommand(request);
			break;
		case LIST:
			System.out.println("----list진입----");
			cmd = new ListCommand(request);
			break;
		case DELETE:
			System.out.println("----delete진입----");
			cmd = new DeleteCommand(request);
			break;
		case COUNT:
			System.out.println("----count진입----");
			cmd = new CountCommand(request);
			break;
		}
		return cmd;
	}
	
}
