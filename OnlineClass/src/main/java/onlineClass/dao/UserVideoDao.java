package onlineClass.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("userVideoDao")
public interface UserVideoDao {

	public List<String> myVideo(String user_id);

	public List<String> myCollection(String user_id);

	public int myGrade(String user_id, String video_id);

	public Boolean isComplete(String user_id, String video_id);
}
