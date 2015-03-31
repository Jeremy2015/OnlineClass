package onlineClass.domain;

import java.sql.Date;

public class UserVideo {

	private String user_id;
	private String video_id;
	private int grade;
	private Date last_watch_time;
	private int mark;
	private int complete;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getLast_watch_time() {
		return last_watch_time;
	}

	public void setLast_watch_time(Date last_watch_time) {
		this.last_watch_time = last_watch_time;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}
}
