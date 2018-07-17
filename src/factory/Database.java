package factory;

import java.sql.*;

public interface Database {
	public Connection getConnection();
}
