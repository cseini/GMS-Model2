package enums;

import template.ColumnFinder;

//
public enum MemberSQL {
	INSERT, 
	LIST, SEARCH, RETRIEVE, COUNT,
	UPDATE,
	DELETE,
	LOGIN, SEARCHCOUNT;
	@Override
	public String toString() {
		String query ="";
		switch (this) { 
		case INSERT:
			query = "INSERT INTO MEMBER    "
					+ " ("
					+ ColumnFinder.find(Domain.MEMBER)
					+")  " 
					+"   VALUES    "
					+"   (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			break;
		case LIST:
			query = " SELECT T.* "
					+" FROM (SELECT ROWNUM RNUM, m.* "
					+"	      FROM member m "
					+"	      ORDER BY RNUM DESC) T "
					+"	WHERE T.RNUM BETWEEN ? AND ?";
			break;
		case SEARCH:
			query = " SELECT T.* " +
					" FROM (SELECT ROWNUM RNUM, m.* "+
					"	      FROM member m " +
					"		  WHERE %s LIKE ? " +
					"	      ORDER BY RNUM DESC) T " +
					"	WHERE T.RNUM BETWEEN ? AND ?  ";
			break;
		case RETRIEVE:
			query = " SELECT " +
					ColumnFinder.find(Domain.MEMBER)
					+" FROM MEMBER "
					+" WHERE USERID "
					+" LIKE ? ";
			break;
		case COUNT:
			query = "SELECT COUNT(*) count FROM MEMBER";
			break;
		case SEARCHCOUNT:
			query = "SELECT COUNT(*) count FROM MEMBER WHERE %s LIKE ?";
			break;
		case UPDATE:
			query = "UPDATE member SET %s = ? WHERE USERID LIKE ? ";
			break;
		case DELETE:
			query = "DELETE FROM member WHERE USERID like ? AND password like ?";
			break;
		case LOGIN:
			query = "SELECT " +
					ColumnFinder.find(Domain.MEMBER) +
					"   FROM MEMBER  "	+
					"   WHERE USERID LIKE ? " +
					"   AND PASSWORD LIKE ? ";
		break;
		default:
			break;
		}
		return query;
	}

}
