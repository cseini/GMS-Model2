package dao;
import java.sql.*;
import java.util.*;
import pool.DBConstant;

public class TestDao {
	private static TestDao instance = new TestDao();
	public static TestDao getInstance() {return instance;}
	private TestDao() {}
	public List<String> getAge() {
		List<String> list = new ArrayList<>();
		try {
			Class.forName(DBConstant.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBConstant.CONNECTION_URL, DBConstant.USERNAME, DBConstant.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = String.format(
					"SELECT AGE   "
					
					+ " FROM  MEMBER "
					);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString("AGE"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void setAge(List<String> list) {
		List<String> ssn = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "seini144", "password");
			Statement stmt = conn.createStatement();
			String sql = String.format(
					"SELECT AGE   "
					+ " FROM  MEMBER "
					);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString("AGE"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
