package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import onlineClass.domain.DbUser;
import onlineClass.domain.User;
import onlineClass.util.JdbcUtil;

public class DbUserDao {

	public DbUser getDatabase(String userId) {

		List<DbUser> users = internalDatabase();

		for (DbUser user : users) {
			if (user.getUser_id().equals(userId) == true) {
				return user;
			}
		}
		throw new RuntimeException("User does not exist!");

	}

	private List<DbUser> internalDatabase() {

		List<DbUser> users = new ArrayList<DbUser>();
		DbUser user = null;

		Connection conn = JdbcUtil.getConn();
		String sql = "select * from user";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				user = new DbUser();
				user.setUser_id(res.getString("user_id"));
				user.setPassword(res.getString("password"));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
	}
}
