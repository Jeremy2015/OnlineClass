package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import onlineClass.domain.Course;
import onlineClass.domain.Roll;
import onlineClass.domain.Video;
import onlineClass.util.JdbcUtil;

import org.springframework.stereotype.Component;


@Component("rollDaoImpl")
public class RollDaoImpl implements RollDao{

	
	@Override
	public List<Roll> rollList(){
		List<Roll> rollList = new ArrayList<Roll>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from roll";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Roll roll = new Roll();
				roll.setCourse_id(rs.getString(1));
				roll.setRoll_picture(rs.getString(2));
				rollList.add(roll);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rollList;
	}
	
	
	@Override
	public List<Course> rollCourseList(){
		List<Course> rollCourseList=new ArrayList<Course>();
		RollDaoImpl rollDaoImpl=new RollDaoImpl();
		List<Roll> rollList=rollDaoImpl.rollList();
		CourseDaoImpl courseDaoImpl=new CourseDaoImpl();
		rollCourseList=courseDaoImpl.rollCourseList(rollList);
		return rollCourseList;
	}
}
