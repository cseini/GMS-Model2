package enums;
//
public enum MemberQuery {
	LOGIN, INSERT_MEMBER, SELECT_MEMBER_BY_SEQ, MEMBER_COUNT, UPDATE_MEMBER, MEMBER_DELETE, SELECT_ALL, SELECT_TEAM, SELECT_WORD;
	@Override
	public String toString() {
		String query ="";
		switch (this) { 
		case LOGIN:
			query = "SELECT MEM_ID MEMID,  " + 
					" TEAM_ID TEAMID,  " +
					"	NAME,  " +
					"	SSN,  "	+
					"	 ROLL,  " +
					"	 PASSWORD  " +
					"   FROM MEMBER  "	+
					"   WHERE MEM_ID LIKE '%s' " +
					"   AND PASSWORD LIKE '%s' ";
		break;
		case INSERT_MEMBER:
			query = "INSERT INTO MEMBER    " + 
					"   (MEM_ID, NAME, PASSWORD, SSN, AGE, ROLL, GENDER, TEAM_ID)    " +
					"   VALUES    "+
					"   ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
			break;
		case SELECT_MEMBER_BY_SEQ:
			query = "SELECT MEM_ID MEMID, TEAM_ID TEAMID ,NAME,SSN,PASSWORD,ROLL,AGE,GENDER FROM MEMBER WHERE MEM_ID LIKE '%s'";
			break;
		case MEMBER_COUNT:
			query = "SELECT COUNT(*) as count FROM MEMBER";
			break;
		case UPDATE_MEMBER:
			query = "UPDATE member SET password = '%s', team_id='%s', roll='%s' WHERE mem_id LIKE '%s'";
			break;
		case MEMBER_DELETE:
			query = "DELETE FROM member WHERE mem_id like '%s' AND password like '%s'";
			break;
		case SELECT_ALL:
			query = "SELECT MEM_ID MEMID,  " + 
					" TEAM_ID TEAMID,  " +
					"	NAME,  " +
					"	SSN,  "	+
					"	 ROLL,  " +
					"	 PASSWORD, AGE, GENDER  " +
					"   FROM MEMBER  ";
			break;
		case SELECT_WORD:
			query = "SELECT MEM_ID MEMID,  " + 
					" TEAM_ID TEAMID,  " +
					"	NAME,  " +
					"	SSN,  "	+
					"	 ROLL,  " +
					"	 PASSWORD  , AGE, GENDER" +
					"   FROM %s  " +
					" WHERE %s LIKE '%%%s%%' ";
			break;
			
		default:
			break;
		}
		return query;
	}

}
