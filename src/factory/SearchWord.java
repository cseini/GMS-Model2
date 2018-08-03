package factory;

public class SearchWord implements SearchEngine{
	private String sql, table, column, word;
	public SearchWord(String table, String column, String word) {
		this.table = table;
		this.column = column;
		this.word = word;
	}
	@Override
	public String searchDatabase() {

		return sql;
	}
	
}
