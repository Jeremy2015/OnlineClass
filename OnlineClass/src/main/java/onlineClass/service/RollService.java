package onlineClass.service;

import java.util.ArrayList;
import java.util.List;

import onlineClass.dao.RollDao;
import onlineClass.domain.Course;
import onlineClass.domain.Roll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RollService {

	@Autowired
	private RollDao rollDao;
	
	public List<Roll> rollList(){
		List<Roll> rollList = new ArrayList<Roll>();
		rollList = rollDao.rollList();
		return rollList;
	}
	
	public List<Course> rollCourseList(){
		List<Course> rollCourseList = new ArrayList<Course>();
		rollCourseList = rollDao.rollCourseList();
		return rollCourseList;
	}

}
