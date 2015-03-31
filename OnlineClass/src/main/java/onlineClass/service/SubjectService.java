package onlineClass.service;

import java.util.List;

import onlineClass.dao.SubjectDao;
import onlineClass.domain.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubjectService {

	@Autowired
	private SubjectDao subjectDao;
	public List<Subject> subjectList(){
		List<Subject> subjectList=subjectDao.subjectList();
		return subjectList;
	}
}
