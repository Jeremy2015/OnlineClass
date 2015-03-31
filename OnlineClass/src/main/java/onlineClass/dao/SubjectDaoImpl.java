package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import onlineClass.domain.Roll;
import onlineClass.domain.Subject;
import onlineClass.util.JdbcUtil;

import org.springframework.stereotype.Component;



@Component("subjectDaoImpl")
public class SubjectDaoImpl implements SubjectDao{

	
	@Override
	public List<Subject> subjectList(){
		List<Subject> subjectList = new ArrayList<Subject>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from subject";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setSubject_id(rs.getString(1));
				subject.setSubject_name(rs.getString(2));
				subject.setSubject_info(rs.getString(3));
				subjectList.add(subject);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjectList;
	}
}
