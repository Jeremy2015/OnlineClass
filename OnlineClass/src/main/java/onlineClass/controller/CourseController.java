package onlineClass.controller;

import java.util.LinkedHashMap;
import java.util.List;

import onlineClass.domain.Video;
import onlineClass.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/courseindex", method = RequestMethod.GET)
	public String courseIndexPage() {
		return "courseindex";
	}

	@ResponseBody
	@RequestMapping(value = "/pageList", method = RequestMethod.GET)
	public LinkedHashMap courseList(int currentPage) {
		LinkedHashMap<String,Object> pageMap=new LinkedHashMap<String,Object>();
		pageMap=courseService.pageMap(currentPage);
		return pageMap;
	}
}
