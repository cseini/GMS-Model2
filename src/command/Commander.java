package command;
import enums.*;

public class Commander{
	public static Command order(
			String domain, String action, String page) {
		Command cmd = null;
		switch(Action.valueOf(action.toUpperCase())) {
		case MOVE:
			System.out.println("----무브진입----");
			cmd = new MoveCommand(domain,action,page);
			break;
		case JOIN:
			System.out.println("----조인진입----");
			cmd = new CreateCommand(domain,action,page);
			break;
		case LOGIN:
			System.out.println("----로그인진입----");
			cmd = new LoginCommand(domain,action,page);
			break;
		case UPDATE:
			System.out.println("----업데이트진입----");
			cmd = new UpdateCommand(domain,action,page);
			break;
		case SEARCH:
			System.out.println("----search진입----");
			cmd = new SearchCommand(domain,action,page);
			break;
		case RETRIEVE:
			System.out.println("----retrieve진입----");
			cmd = new RetrieveCommand(domain,action,page);
			break;
		case LIST:
			System.out.println("----list진입----");
			cmd = new ListCommand(domain,action,page);
			break;
		case DELETE:
			System.out.println("----delete진입----");
			cmd = new DeleteCommand(domain,action,page);
			break;
		}
		return cmd;
	}
	
}
