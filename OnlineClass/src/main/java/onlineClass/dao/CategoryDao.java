package onlineClass.dao;

import java.util.List;

import onlineClass.domain.Category;

import org.springframework.stereotype.Repository;



@Repository("categoryDao")
public interface CategoryDao {

	public List<Category> categoryList();
	public List<Category> subjectCategory(String subject_id);
}
