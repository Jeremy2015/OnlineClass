package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import onlineClass.domain.Course;
import onlineClass.domain.Roll;
import onlineClass.domain.Video;
import onlineClass.util.JdbcUtil;

import org.springframework.stereotype.Component;



@Component("courseDaoImpl")
public class CourseDaoImpl implements CourseDao{

	
	@Override
	public List<Course> courseList(){
		List<Course> courseList = new ArrayList<Course>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from course";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Course course=new Course();
				course.setCourse_id(rs.getString(1));
				course.setCourse_name(rs.getString(2));
				course.setCategory_id(rs.getString(3));
				course.setPicture(rs.getString(4));
				course.setCourse_info(rs.getString(5));
				course.setUniversity_name(rs.getString(6));
				courseList.add(course);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}
	
	
	
	@Override
	public Course courseInfo(String course_id){
		Course course=new Course();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from course where course_id='"+course_id+"'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				course.setCourse_id(rs.getString(1));
				course.setCourse_name(rs.getString(2));
				course.setCategory_id(rs.getString(3));
				course.setPicture(rs.getString(4));
				course.setCourse_info(rs.getString(5));
				course.setUniversity_name(rs.getString(6));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}
	
	
	@Override
	public List<Course> randomList(int number){
		List<Course> randomList=new ArrayList<Course>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from course order by rand() limit "+number;
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Course course=new Course();
				course.setCourse_id(rs.getString(1));
				course.setCourse_name(rs.getString(2));
				course.setCategory_id(rs.getString(3));
				course.setPicture(rs.getString(4));
				course.setCourse_info(rs.getString(5));
				course.setUniversity_name(rs.getString(6));
				randomList.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return randomList;
	}
	
	
	@Override
	public LinkedHashMap<String,Object> pageMap(int currentPage){
		int pageSize=3;
		LinkedHashMap<String,Object> pageMap=new LinkedHashMap<String,Object>();
		List<Course> pageList=new ArrayList<Course>();
		PageDao pageDao=new PageDao();
		int pages=pageDao.getPages("course",pageSize);

		int beginRecord = (currentPage-1)*pageSize;//开始记录
		int endRecord = pageSize;//从开始到结束的记录数
		String sql = "select * from course limit "+beginRecord+","+endRecord+"";
		Connection conn = JdbcUtil.getConn();
		Statement st;
		
		try {//resultSet的get方法赋值得到一个Person对象
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Course course=new Course();
				course.setCourse_id(rs.getString(1));
				course.setCourse_name(rs.getString(2));
				course.setCategory_id(rs.getString(3));
				course.setPicture(rs.getString(4));
				course.setCourse_info(rs.getString(5));
				course.setUniversity_name(rs.getString(6));
				pageList.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pageMap.put("pages", pages);
        JSONArray json = new JSONArray();  
        json.addAll(pageList);
		pageMap.put("pageList",json);
		return pageMap;
	}
	
	@Override
	public List<Course> rollCourseList(List<Roll> rollList){
		List<Course> rollCourseList = new ArrayList<Course>();
		Connection conn = JdbcUtil.getConn();
		Statement st;
		try {
			st = conn.createStatement();
			for(int i=0;i<rollList.size();i++){
				Roll roll=rollList.get(i);
				String sql = "select * from course where course_id='"+roll.getCourse_id()+"'";
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					Course course=new Course();
					course.setCourse_id(rs.getString(1));
					course.setCourse_name(rs.getString(2));
					course.setCategory_id(rs.getString(3));
					course.setPicture(rs.getString(4));
					course.setCourse_info(rs.getString(5));
					course.setUniversity_name(rs.getString(6));
					rollCourseList.add(course);
				}
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rollCourseList;
	}
	
}
