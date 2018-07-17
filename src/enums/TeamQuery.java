package enums;

public enum TeamQuery {
	TEAM_COUNT, INSERT_TEAM, DELETE_TEAM, UPDATE_NAME, TEAM_LIST, SEARCH_TEAMID, SEARCH_TEAMNAME;
	public String toString() {
		String query = "";
		switch (this) {
		case TEAM_COUNT:
			query = "SELECT COUNT(*) AS count  FROM project_team";
			break;
		case INSERT_TEAM:
			query = "INSERT INTO PROJECT_TEAM" +
					" (TEAM_ID, TEAM_NAME)"+
					" VALUES"+
					" ('%s', '%s')";
			break;
		case DELETE_TEAM:
			query = "DELETE FROM PROJECT_TEAM" +
					" WHERE TEAM_ID LIKE '%s' " +
					" AND TEAM_NAME LIKE '%s' ";
			break;
		case UPDATE_NAME:
			query = "UPDATE project_team SET team_name = '%s' WHERE team_id LIKE '%s' AND team_name LIKE '%s'";
			break;
		case TEAM_LIST:
			query ="SELECT team_id, team_name FROM project_team";
			break;
		case SEARCH_TEAMID:
			query="SELECT team_id, team_name FROM project_team WHERE team_id like '%s'";
			break;
		case SEARCH_TEAMNAME:
			query = "SELECT team_id, team_name FROM project_team WHERE team_name like '%s'";
			break;
		default:
			break;
		}
		
		return query;
	}
}

