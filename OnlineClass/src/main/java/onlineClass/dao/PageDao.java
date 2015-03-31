package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import onlineClass.domain.Course;
import onlineClass.domain.Video;
import onlineClass.util.JdbcUtil;


//分页Dao
public class PageDao {

	
	public int getPages(String table_name,int pageSize){
		/**
		 * SQL语句计算查询的总记录数
		 * @return 查询person的总页数
		 */
		int totalPages = 0;//总页数totalPages
		Connection conn = JdbcUtil.getConn();
		String sql = "select count(*) from "+table_name;
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				int totalRecords = rs.getInt(1);//总记录数totalRecords
				totalPages=totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalPages;
	}
	
	
	
	
	/**
	 * @return 返回当前页查询结果的List
	 */
//	public List show(int currentPage){
//
//		Video video;
//		int beginRecord = (currentPage-1)*pageSize;//开始记录
//		int endRecord = pageSize;//从开始到结束的记录数
//		String sql = "select * from video limit "+beginRecord+","+endRecord+"";
//		List videoList = new ArrayList();
//		Connection conn = JdbcUtil.getConn();
//		Statement st;
//		
//		try {//resultSet的get方法赋值得到一个Person对象
//			st = conn.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			while(rs.next()){
//				video = new Video();
//				video.setVideo_id(rs.getString(1));
//				video.setVideo_name(rs.getString(2));
//				video.setVideo_url(rs.getString(3));
//				video.setClass_id(rs.getString(4));
//				video.setPlay_time(rs.getInt(5));
//				video.setVideo_score(rs.getInt(6));
//				video.setUploadTime(rs.getDate(7));
//				videoList.add(video);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return videoList;
//	}
	
	
	public static void main(String args[]){
		
		List<Course> randomList=new ArrayList<Course>();
		int count = 0;
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from course order by rand() limit 3";
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
				randomList.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray json = new JSONArray();  
        json.addAll(randomList);
    	System.out.println(json.toString());
        
        
//		Map<String,Integer> test=new HashMap<String,Integer>();
//		Iterator iter = test.entrySet().iterator();
//		System.out.println(test.size());
//		while (iter.hasNext()) {
//			Map.Entry entry = (Map.Entry) iter.next();
//			String key = entry.getKey().toString();
//			Integer val = (Integer)entry.getValue();
//			System.out.println(val);
//	    }

//		
//		PageDao pageDao=new PageDao();
//		System.out.println("页数："+pageDao.getPages());
//		List pageList=pageDao.show(2);
//		if(pageList.size()>0){
//			for(int i=0;i<pageList.size();i++){
//				Video video=(Video)pageList.get(i);
//				System.out.println(video.getVideo_url());
//			}
//		}
//		else{
//			System.out.println("pageList is null");
//		}
	}
	
	
}