package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import onlineClass.domain.UserVideo;
import onlineClass.domain.Video;
import onlineClass.util.JdbcUtil;

@Component("userVideoDaoImpl")
public class UserVideoDaoImpl implements UserVideoDao {

	@Override
	public List<String> myVideo(String user_id) {
		List<String> video_idList = new ArrayList<String>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select video_id from user_video where user_id='"
				+ user_id + "'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String video_id = rs.getString(1);
				video_idList.add(video_id);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return video_idList;
	}

	@Override
	public List<String> myCollection(String user_id) {
		List<String> video_idList = new ArrayList<String>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select video_id from user_video where user_id='"
				+ user_id + "' and mark='1'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String video_id = rs.getString(1);
				video_idList.add(video_id);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return video_idList;
	}

	@Override
	public int myGrade(String user_id, String video_id) {
		int grade = 0;
		Connection conn = JdbcUtil.getConn();
		String sql = "select grade from user_video where user_id='" + user_id
				+ "' and video_id='" + video_id + "'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				grade = rs.getInt(1);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grade;
	}

	@Override
	public Boolean isComplete(String user_id, String video_id) {
		int isComplete = 0;
		Connection conn = JdbcUtil.getConn();
		String sql = "select complete from user_video where user_id='"
				+ user_id + "' and video_id='" + video_id + "'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				isComplete = rs.getInt(1);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isComplete == 0) {
			return false;
		} else {
			return true;
		}
	}
}
