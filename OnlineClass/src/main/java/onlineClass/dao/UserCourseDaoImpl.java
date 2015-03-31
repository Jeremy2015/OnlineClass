package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import onlineClass.domain.Course;
import onlineClass.util.JdbcUtil;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Component("userCourseDaoImpl")
public class UserCourseDaoImpl implements UserCourseDao{
	
	
	
	@Override
	public List<Course> myCourse(){
		// //////////get my id//////////////
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String my_id = userDetails.getUsername();
		
		List<Course> courseList=new ArrayList<Course>(); 
		List<String> course_idList=new ArrayList<String>(); 
		Connection conn = JdbcUtil.getConn();
		String sql = "select course_id from user_course where user_id='"+my_id+"'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String course_id=rs.getString(1);
				course_idList.add(course_id);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		courseList=getcourse(course_idList);
		return courseList;
	}
	
	
	
	@Override
    public boolean participte(String course_id){
		// //////////get my id//////////////
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String my_id = userDetails.getUsername();
		
		Connection conn = JdbcUtil.getConn();
		Statement st;
		String sql = "insert into user_course(user_id,course_id) values('"
				+ my_id
				+ "','"
				+ course_id + "')";
		try {
			st = conn.createStatement();
			int add = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	public static List<Course> getcourse(List<String> course_idList){
		List<Course> courseList=new ArrayList<Course>(); 
		Connection conn = JdbcUtil.getConn();
		Statement st;
		try {
			st = conn.createStatement();
			for(int i=0;i<course_idList.size();i++){
				String sql = "select * from course where course_id='"+course_idList.get(i)+"'";
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					Course course=new Course();
					course.setCourse_id(rs.getString(1));
					course.setCourse_name(rs.getString(2));
					course.setCategory_id(rs.getString(3));
					course.setPicture(rs.getString(4));
					course.setCourse_info(rs.getString(5));
					courseList.add(course);
				}
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}
	
	
	@Override
    public boolean isParticipte(String course_id){
    	
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String my_id = userDetails.getUsername();
		
    	Connection conn = JdbcUtil.getConn();
    	
		String sql = "select count(*) from user_course where user_id='"+my_id+"' and course_id='"+course_id+"'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				int count = rs.getInt(1);
				if(count==1){
					return true;
				}
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    }
}
