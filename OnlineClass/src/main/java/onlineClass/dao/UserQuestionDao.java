package onlineClass.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import onlineClass.domain.UserQuestion;

@Repository("userQuestionDao")
public interface UserQuestionDao {

	public boolean setResult(String user_id, String question_id, int result);

	public int getResult(String user_id, String question_id);

	public boolean mark(String user_id, String question_id);

	public List<UserQuestion> myMarkList();
}
