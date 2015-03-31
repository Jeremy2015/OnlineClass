package onlineClass.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import onlineClass.dao.VideoDao;
import onlineClass.domain.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

	@Autowired
	private VideoDao videoDao;

	public List<Video> videoSearch(String[] keywords) {
		List<Video> videoList = new ArrayList<Video>();
		videoList = videoDao.videoSearch(keywords);
		return videoList;
	}
	
	
	public LinkedHashMap<String,Object> pageMap(int currentPage){
		LinkedHashMap<String,Object> pageMap=new LinkedHashMap<String,Object>();
		pageMap=videoDao.pageMap(currentPage);
		return pageMap;
	}
}
