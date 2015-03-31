package onlineClass.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	public static String driverName;
	public static String url;
	public static String user;
	public static String password;

	static {

		Properties prop = new Properties();
		InputStream in = JdbcUtil.class.getResourceAsStream("db.properties");

		try {
			prop.load(in);

			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");

			Class.forName(driverName);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet res, Statement stmt, Connection conn) {
		try {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(JdbcUtil.getConn());
	}
}
