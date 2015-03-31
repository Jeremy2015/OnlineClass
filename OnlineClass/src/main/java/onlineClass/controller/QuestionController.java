package onlineClass.controller;

import java.util.ArrayList;
import java.util.List;

import onlineClass.domain.Question;
import onlineClass.domain.User;
import onlineClass.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/questionpage", method = RequestMethod.GET)
	public String getquestionpage(Model model) {
		List<Question> questionList = questionService
				.questionListByVideo("java_01");
		if (questionList.size() > 0) {
			model.addAttribute("questionList", questionList);
		} else {
			return "failpage";
		}
		return "questionpage";
	}
}
