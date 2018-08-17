package enums;

public enum ImageSQL {
	INSERT, READ;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case INSERT:
			query = " INSERT INTO IMAGE(IMGSEQ, IMGNAME, EXTENSION, USERID) " +
					" VALUES (IMG_SEQ.NEXTVAL, ?, ?, ?) ";
			break;
		case READ:
			query = "  SELECT IMGNAME, EXTENSION, USERID   " +
					"  FROM IMAGE  "
					+ "  WHERE USERID LIKE ?  ";
			break;

		default:
			break;
		}
		return query;
	}
}
