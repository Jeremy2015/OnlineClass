package onlineClass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import onlineClass.domain.Category;
import onlineClass.domain.Course;
import onlineClass.util.JdbcUtil;



@Component("categoryDaoImpl")
public class CategoryDaoImpl implements CategoryDao{

	
	@Override
	public List<Category> categoryList(){
		List<Category> categoryList = new ArrayList<Category>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from category";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Category category=new Category();
				category.setCategory_id(rs.getString(1));
				category.setCategory_name(rs.getString(2));
				category.setCategory_info(rs.getString(3));
				category.setSubject_id(rs.getString(4));
				categoryList.add(category);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}
	
	
	@Override
	public List<Category> subjectCategory(String subject_id){
		List<Category> categoryList = new ArrayList<Category>();
		Connection conn = JdbcUtil.getConn();
		String sql = "select * from category where subject_id='"+subject_id+"'";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Category category=new Category();
				category.setCategory_id(rs.getString(1));
				category.setCategory_name(rs.getString(2));
				category.setCategory_info(rs.getString(3));
				category.setSubject_id(rs.getString(4));
				categoryList.add(category);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}
}
