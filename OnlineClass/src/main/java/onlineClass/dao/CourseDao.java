package onlineClass.dao;

import java.util.LinkedHashMap;
import java.util.List;

import onlineClass.domain.Course;
import onlineClass.domain.Roll;

import org.springframework.stereotype.Repository;



@Repository("courseDao")
public interface CourseDao {

	public List<Course> courseList();
	public List<Course> rollCourseList(List<Roll> rollList);
	public Course courseInfo(String course_id);
	public List<Course> randomList(int number);
	public LinkedHashMap<String,Object> pageMap(int currentPage);
}
