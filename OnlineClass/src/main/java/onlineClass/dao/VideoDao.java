package onlineClass.dao;

import java.util.LinkedHashMap;
import java.util.List;

import onlineClass.domain.Video;

import org.springframework.stereotype.Repository;

@Repository("videoDao")
public interface VideoDao {

	public List<Video> videoList();

	public List<Video> videoByClass(String class_id);

	public List<Video> videoSearch(String[] keywords);

	public String videoURL(String video_id);

	// public List<Video> videoByUpTime();
	// public List<Video> videoByScore();
	
	public LinkedHashMap<String,Object> pageMap(int currentPage);
}
