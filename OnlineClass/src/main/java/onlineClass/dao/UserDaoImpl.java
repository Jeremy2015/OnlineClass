package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import onlineClass.domain.User;
import onlineClass.encryption.MD5;
import onlineClass.util.JdbcUtil;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {

	// /////////////userList///////////////
	@Override
	public List<User> userList() {
		List userList = new ArrayList<User>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from user";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getString(1));
				user.setUser_name(rs.getString(2));
				user.setPassword(rs.getString(3));
				userList.add(user);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	public Boolean modify(User user) {
		Connection conn = JdbcUtil.getConn();
		String sql = "update user set user_name='"+user.getUser_name()+"' and password='" + user.getPassword()
				+ "' where user_id='" + user.getUser_id() + "'";
		Statement st;
		try {
			st = conn.createStatement();
			int rs = 0;
			rs = st.executeUpdate(sql);
			if (rs == 0) {
				conn.close();
				return false;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public User myInfo() {
		// //////////get my id//////////////
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		String my_id = userDetails.getUsername();
		User user = null;
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from user where user_id='" + my_id + "'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				user = new User();
				user.setUser_id(rs.getString(1));
				user.setUser_name(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	

	
	public Boolean addUser(User user) {
		Connection conn = JdbcUtil.getConn();
		Statement st;
		String query="select user_id from user";
		String sql = "insert into user(user_id,user_name,password,role_id) values('"
				+ user.getUser_id()
				+ "','"
				+ user.getUser_name()
				+ "','"
				+ user.getPassword() + "')";
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String user_id=rs.getString(1);
				if(user_id.equals(user.getUser_id())) return false;
			}
			int add = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
