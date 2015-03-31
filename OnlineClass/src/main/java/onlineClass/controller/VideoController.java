package onlineClass.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import onlineClass.domain.Video;
import onlineClass.service.VideoService;

import org.apache.commons.collections.map.LinkedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@RequestMapping(value = "/videopage", method = RequestMethod.GET)
	public String profilePage() {
		return "videopage";
	}

	@RequestMapping(value = "/searchpage", method = RequestMethod.GET)
	public String searchPage() {
		return "searchpage";
	}

	@RequestMapping(value = "/pageListPage", method = RequestMethod.GET)
	public String pageListPage() {
		return "pagelist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public LinkedHashMap<String,String> search(String keyword){
		String[] keywords;
		keyword = keyword.trim();
		keyword = keyword.replaceAll("[\\pP|\\pS]", " ");
		keyword = keyword.replaceAll("\\s{1,}", " ");
		keywords = keyword.split(" ");
		
		LinkedHashMap<String,String> videoMap=new LinkedHashMap<String,String>();
		List<Video> videoList=videoService.videoSearch(keywords);
		if(videoList.size()==0){
			return null;
		}
		else{
			for(int i=0;i<videoList.size();i++){
				Video video = videoList.get(i);
				videoMap.put(video.getVideo_url(),video.getVideo_name());
			}
			return videoMap;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public LinkedHashMap<String,Object> allVideo(int currentPage){
		LinkedHashMap<String,Object> pageMap=new LinkedHashMap<String,Object>();
		pageMap=videoService.pageMap(currentPage);
		return pageMap;
	}
}
