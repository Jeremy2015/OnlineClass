package onlineClass.service;

import java.util.List;

import onlineClass.dao.QuestionDao;
import onlineClass.domain.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;

	public List<Question> questionList() {
		List<Question> questionList = questionDao.questionList();
		return questionList;
	}

	public List<Question> questionListByVideo(String video_id) {
		List<Question> questionList = questionDao.questionListByVideo(video_id);
		return questionList;
	}

	public Question questionById(String question_id) {
		Question question = new Question();
		question = questionDao.questionById(question_id);
		return question;
	}

}
