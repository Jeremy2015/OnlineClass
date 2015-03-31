package onlineClass.dao;

import java.util.List;

import onlineClass.domain.Subject;

import org.springframework.stereotype.Repository;



@Repository("subjectDao")
public interface SubjectDao {

	public List<Subject> subjectList();
}
