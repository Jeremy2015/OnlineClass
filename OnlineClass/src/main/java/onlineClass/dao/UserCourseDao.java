package onlineClass.dao;

import java.util.LinkedHashMap;
import java.util.List;

import onlineClass.domain.Course;

import org.springframework.stereotype.Repository;


@Repository("userCourseDao")
public interface UserCourseDao {
    public List<Course> myCourse();
    public boolean participte(String course_id);
    public boolean isParticipte(String course_id);
}

