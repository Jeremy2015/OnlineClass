package onlineClass.service;

import java.util.List;

import onlineClass.dao.CategoryDao;
import onlineClass.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> categoryList(){
		List<Category> categoryList=categoryDao.categoryList();
		return categoryList;
	}
	
	public List<Category> subjectCategory(String subject_id){
		List<Category> categoryList=categoryDao.subjectCategory(subject_id);
		return categoryList;
	}
}
