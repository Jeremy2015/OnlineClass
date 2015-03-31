package onlineClass.controller;

import java.util.ArrayList;
import java.util.List;

import onlineClass.dao.UserDaoImpl;
import onlineClass.domain.Category;
import onlineClass.domain.Course;
import onlineClass.domain.Roll;
import onlineClass.domain.Subject;
import onlineClass.domain.User;
import onlineClass.service.CategoryService;
import onlineClass.service.CourseService;
import onlineClass.service.RollService;
import onlineClass.service.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/navigator")
public class NavigatorController {

	@Autowired
	private RollService rollService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(value = "/director", method = RequestMethod.GET)
	public String navigaterPage() {
		return "navigator";
	}

	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexPage(Model model) {
		//CustomUserDetailsService customUserDetailsService=new CustomUserDetailsService();
		//String user_id=customUserDetailsService.getUser_id();
		//System.out.println("user_id="+user_id);
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		User user=new User();
		user=userDaoImpl.myInfo();
		String my_name=user.getUser_name();
		
		List<List<Category>> cat_listList=new ArrayList<List<Category>>();
		List<Subject> subjectList=subjectService.subjectList();
		for(int i=0;i<subjectList.size();i++){
			List<Category> categoryList=categoryService.subjectCategory(subjectList.get(i).getSubject_id());
			cat_listList.add(categoryList);
		}	
		List<Roll> rollList = rollService.rollList();
		List<Course> rollCourseList = rollService.rollCourseList();
		List<Course> randomList = courseService.randomList(2);
		List<Course> recoomandList = courseService.randomList(12);
		
		model.addAttribute("my_name", my_name);
		model.addAttribute("cat_listList",cat_listList);
		model.addAttribute("subjectList",subjectList);
		model.addAttribute("rollList",rollList);
		model.addAttribute("rollCourseList",rollCourseList);
		model.addAttribute("randomList",randomList);
		model.addAttribute("recoomandList",recoomandList);

		return "index";
	}
}
