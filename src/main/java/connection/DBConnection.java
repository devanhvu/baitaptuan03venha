package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=ltweb;encrypt=true;trustServerCertificate=true";
	private static final String USER_NAME = "sa";
	private static final String PASSWORD = "anhvu031025@";
	private static Connection con;

	public static Connection getConnection() throws ClassNotFoundException {
		con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
		}
		return con;
	}

	public static void main(String[] args) {
		try {
			Connection c = getConnection();
			if (c == null) {
				System.out.println("lỗi kết nối");
			} else {
				System.out.println("OK");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
