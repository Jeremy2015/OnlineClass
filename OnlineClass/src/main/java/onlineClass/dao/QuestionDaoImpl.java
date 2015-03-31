package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import onlineClass.domain.Question;
import onlineClass.util.JdbcUtil;

import org.springframework.stereotype.Component;

@Component("questionDaoImpl")
public class QuestionDaoImpl implements QuestionDao {

	@Override
	public List<Question> questionList() {
		List<Question> questionList = new ArrayList<Question>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from question";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Question question = new Question();
				question.setQuestion_id(rs.getString(1));
				question.setVideo_id(rs.getString(2));
				question.setQuestion_name(rs.getString(3));
				question.setOption_a(rs.getString(4));
				question.setOption_b(rs.getString(5));
				question.setOption_c(rs.getString(6));
				question.setOption_d(rs.getString(7));
				question.setAnswer(rs.getString(8));
				questionList.add(question);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionList;
	}

	@Override
	public List<Question> questionListByVideo(String video_id) {
		List<Question> questionList = new ArrayList<Question>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from question where video_id='" + video_id + "'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Question question = new Question();
				question.setQuestion_id(rs.getString(1));
				question.setVideo_id(rs.getString(2));
				question.setQuestion_name(rs.getString(3));
				question.setOption_a(rs.getString(4));
				question.setOption_b(rs.getString(5));
				question.setOption_c(rs.getString(6));
				question.setOption_d(rs.getString(7));
				question.setAnswer(rs.getString(8));
				questionList.add(question);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionList;
	}

	@Override
	public Question questionById(String question_id) {
		Question question = new Question();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from question where question_id='" + question_id
				+ "'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				question.setQuestion_id(rs.getString(1));
				question.setVideo_id(rs.getString(2));
				question.setQuestion_name(rs.getString(3));
				question.setOption_a(rs.getString(4));
				question.setOption_b(rs.getString(5));
				question.setOption_c(rs.getString(6));
				question.setOption_d(rs.getString(7));
				question.setAnswer(rs.getString(8));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return question;
	}
}
