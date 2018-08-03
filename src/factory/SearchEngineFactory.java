package factory;
import enums.*;

public class SearchEngineFactory {
	public static String createSql(Domain v, String option, String word) {
		return "SELECT MEM_ID MEMID,  " + 
				" TEAM_ID TEAMID,  " +
				" NAME,  " +
				" SSN,  "	+
				" ROLL,  " +
				" PASSWORD  , AGE, GENDER" +
				" FROM   " + v +
				" WHERE "+ option +" LIKE '%%"+ word +"%%' ";
	}
}
