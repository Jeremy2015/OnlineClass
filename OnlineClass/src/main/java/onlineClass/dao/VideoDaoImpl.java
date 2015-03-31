package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import onlineClass.domain.Video;
import onlineClass.util.JdbcUtil;

import org.springframework.stereotype.Component;

@Component("videoDaoImpl")
public class VideoDaoImpl implements VideoDao {

	
	@Override
	public List<Video> videoList() {
		List videoList = new ArrayList<Video>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from video";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Video video = new Video();
				video.setVideo_id(rs.getString(1));
				video.setVideo_name(rs.getString(2));
				video.setVideo_url(rs.getString(3));
				video.setClass_id(rs.getString(4));
				video.setPlay_time(rs.getInt(5));
				video.setVideo_score(rs.getInt(6));
				video.setUploadTime(rs.getDate(7));
				videoList.add(video);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoList;
	}

	@Override
	public List<Video> videoByClass(String class_id) {
		List videoList = new ArrayList<Video>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from video where class_id='" + class_id + "'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Video video = new Video();
				video.setVideo_id(rs.getString(1));
				video.setVideo_name(rs.getString(2));
				video.setVideo_url(rs.getString(3));
				video.setClass_id(rs.getString(4));
				video.setPlay_time(rs.getInt(5));
				video.setVideo_score(rs.getInt(6));
				video.setUploadTime(rs.getDate(7));
				videoList.add(video);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoList;
	}

	@Override
	public List<Video> videoSearch(String[] keywords) {
		ConcurrentHashMap<String,Integer> sortMap=new ConcurrentHashMap<String,Integer>();
		List videoList = new ArrayList<Video>();
		Connection conn = JdbcUtil.getConn();
		List<String> sqlList=new ArrayList<String>();
		if(keywords.length==0||keywords==null||keywords[0].equals("")){
			String sql = "select video_id from video";          
			sqlList.add(sql);
		}
		else if(keywords.length==1){
			String sql = "select video_id from video where video_name like '%" + keywords[0] +"%'";
			sqlList.add(sql);
		}
		else if(keywords.length==2){
			String sql1 = "select video_id from video where video_name like '%" + keywords[0] +"%'";
			String sql2 = "select video_id from video where video_name like '%" + keywords[1] +"%'";
			sqlList.add(sql1);
			sqlList.add(sql2);
		}
		else{
			String sql1 = "select video_id from video where video_name like '%" + keywords[0] +"%'";
			String sql2 = "select video_id from video where video_name like '%" + keywords[1] +"%'";
			String sql3 = "select video_id from video where video_name like '%" + keywords[2] +"%'";
			sqlList.add(sql1);
			sqlList.add(sql2);
			sqlList.add(sql3);
		}
		
		Statement st;
		try {
			st = conn.createStatement();
			for(int i=0;i<sqlList.size();i++){
				ResultSet rs = st.executeQuery(sqlList.get(i));
				while (rs.next()) {
					if(sortMap.size()>0){
						Iterator iter = sortMap.entrySet().iterator();
						while (iter.hasNext()) {
							Map.Entry entry = (Map.Entry) iter.next();
							String key = entry.getKey().toString();
							Integer val = (Integer)entry.getValue();
							if (sortMap.get(rs.getString(1)) != null) {  
			                    val++;  
			                    sortMap.put(rs.getString(1), val);  
			                } 
							else{
			                    sortMap.put(rs.getString(1), 1);  
							}  
					    }
					}
					else{
						sortMap.put(rs.getString(1), 1);
					}
				}
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		VideoDaoImpl videoDaoImpl=new VideoDaoImpl();
		List sortList=videoDaoImpl.sort(sortMap);
		videoList=videoDaoImpl.videoListByIdList(sortList);
		
		return videoList;
	}

	@Override
	public String videoURL(String video_id) {
		String video_url = "";
		Connection conn = JdbcUtil.getConn();
		String sql = "select video_url from video where video_id='" + video_id
				+ "'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				video_url = rs.getString(1);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return video_url;
	}

	

	
	@Override
	public LinkedHashMap<String,Object> pageMap(int currentPage){
		int pageSize=5;
		LinkedHashMap<String,Object> pageMap=new LinkedHashMap<String,Object>();
		List<Video> pageList=new ArrayList<Video>();
		PageDao pageDao=new PageDao();
		int pages=pageDao.getPages("video",pageSize);	

		int beginRecord = (currentPage-1)*pageSize;//开始记录
		int endRecord = pageSize;//从开始到结束的记录数
		String sql = "select * from video limit "+beginRecord+","+endRecord+"";
		Connection conn = JdbcUtil.getConn();
		Statement st;
		
		try {//resultSet的get方法赋值得到一个Person对象
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Video video = new Video();
				video.setVideo_id(rs.getString(1));
				video.setVideo_name(rs.getString(2));
				video.setVideo_url(rs.getString(3));
				video.setClass_id(rs.getString(4));
				video.setPlay_time(rs.getInt(5));
				video.setVideo_score(rs.getInt(6));
				video.setUploadTime(rs.getDate(7));
				pageList.add(video);
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
		for(int i=0;i<pageList.size();i++){
			Video video=pageList.get(i);
			String url=video.getVideo_url();
			String name=video.getVideo_name();
			pageMap.put(url, name);
		}
		return pageMap;
	}
	
	
	public List sort(Map<String,Integer> sortMap){
		List sortList =new ArrayList();
        List tempList = new ArrayList(sortMap.entrySet());  
        
        Collections.sort(sortList, new Comparator(){  
            public int compare(Object o1, Object o2) {  
                Map.Entry obj1 = (Map.Entry) o1;  
                Map.Entry obj2 = (Map.Entry) o2;  
                return ((Integer) obj2.getValue()).compareTo((Integer)obj1.getValue());  
                }  
        });
        
        for(int i=0;i<tempList.size();i++){
        	String temp=tempList.get(i).toString();
        	temp=temp.substring(0, temp.length()-2);
        	sortList.add(temp);
        }
		return sortList;
	}
	
	
	
	public List<Video> videoListByIdList(List<String> idList){
		List videoList = new ArrayList<Video>();
		Connection conn = JdbcUtil.getConn();
		Statement st;
		try {
			st = conn.createStatement();
			for(int i=0;i<idList.size();i++){
				String sql = "select * from video where video_id='" +idList.get(i)+ "'";
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getString(1));
					video.setVideo_name(rs.getString(2));
					video.setVideo_url(rs.getString(3));
					video.setClass_id(rs.getString(4));
					video.setPlay_time(rs.getInt(5));
					video.setVideo_score(rs.getInt(6));
					video.setUploadTime(rs.getDate(7));
					videoList.add(video);
				}
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoList;
	}
	
	
	
}
