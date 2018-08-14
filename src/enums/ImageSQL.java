package enums;

public enum ImageSQL {
	INSERT, READ;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case INSERT:
			query = " INSERT INTO IMAGE(IMG_SEQ, IMG_NAME, EXTENSION, USERID) " +
					" VALUES (IMG_SEQ.NEXTVAL, ?, ?, ?) ";
			break;
		case READ:
			query = "  SELECT IMG_NAME, EXTENSION, USERID   " +
					"  FROM IMAGE  "
					+ "  WHERE USERID LIKE ?  ";
			break;

		default:
			break;
		}
		return query;
	}
}
