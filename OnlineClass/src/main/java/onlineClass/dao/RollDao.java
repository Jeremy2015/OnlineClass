package onlineClass.dao;

import java.util.List;

import onlineClass.domain.Course;
import onlineClass.domain.Roll;

import org.springframework.stereotype.Repository;


@Repository("rollDao")
public interface RollDao {

	public List<Roll> rollList();
	public List<Course> rollCourseList();
}
