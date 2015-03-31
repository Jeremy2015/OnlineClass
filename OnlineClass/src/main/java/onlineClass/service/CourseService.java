package onlineClass.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import onlineClass.dao.CourseDao;
import onlineClass.domain.Course;
import onlineClass.domain.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseDao courseDao;

	
	public List<Course> courseList() {
		List<Course> courseList = new ArrayList<Course>();
		courseList = courseDao.courseList();
		return courseList;
	}
	
	public Course courseInfo(String course_id){
		Course course=courseDao.courseInfo(course_id);
		return course;
	}
	
	public List<Course> randomList(int number){
		List<Course> randomList = new ArrayList<Course>();
		randomList=courseDao.randomList(number);
		return randomList;
	}
	
	public LinkedHashMap<String,Object> pageMap(int currentPage){
		LinkedHashMap<String,Object> pageMap=new LinkedHashMap<String,Object>();
		pageMap=courseDao.pageMap(2);
		return pageMap;
	}
}
