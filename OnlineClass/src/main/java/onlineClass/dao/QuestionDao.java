package onlineClass.dao;

import java.util.List;

import onlineClass.domain.Question;

import org.springframework.stereotype.Repository;

@Repository("questionDao")
public interface QuestionDao {

	public List<Question> questionList();

	public List<Question> questionListByVideo(String video_id);

	public Question questionById(String question_id);
}
