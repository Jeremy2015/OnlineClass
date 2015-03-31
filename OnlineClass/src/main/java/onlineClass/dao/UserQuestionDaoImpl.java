package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import onlineClass.domain.UserQuestion;
import onlineClass.domain.Video;
import onlineClass.util.JdbcUtil;

@Component("userQuestionDaoImpl")
public class UserQuestionDaoImpl implements UserQuestionDao {

	@Override
	public boolean setResult(String user_id, String question_id, int result) {
		Connection conn = JdbcUtil.getConn();
		String sql = "update user_question set result='" + result
				+ "' where user_id='" + user_id + "' and question_id='"
				+ question_id + "'";
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
			return false;
		}
		return true;
	}

	@Override
	public int getResult(String user_id, String question_id) {
		int result = -1;
		Connection conn = JdbcUtil.getConn();
		String sql = "select result from user_question where user_id='"
				+ user_id + "' and question_id='" + question_id + "'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean mark(String user_id, String question_id) {
		Connection conn = JdbcUtil.getConn();
		String sql = "update user_question set mark='1' where user_id='"
				+ user_id + "' and question_id='" + question_id + "'";
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
			return false;
		}
		return true;

	}

	@Override
	public List<UserQuestion> myMarkList() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String my_id = userDetails.getUsername();
		List<UserQuestion> myMarkList = new ArrayList<UserQuestion>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from user_question where user_id = '" + my_id
				+ "' and mark='1'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				UserQuestion userQuestion = new UserQuestion();
				userQuestion.setUser_id(rs.getString(1));
				userQuestion.setQuestion_id(rs.getString(2));
				userQuestion.setResult(rs.getInt(3));
				userQuestion.setMark(rs.getInt(4));
				myMarkList.add(userQuestion);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myMarkList;
	}
}
