package JewelryShop.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import JewelryShop.Entity.MapperUser;
import JewelryShop.Entity.User;
@Repository
public class UserDao extends BaseDao {
	private JdbcTemplate jdbcTemplate;
	public UserDao(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public int addUser(User user) {
		String sql="INSERT INTO `jewelryshop`.`user` (`user_name`, `user_pass`, `user_email`, `user_role`, `user_fullname`) "
				+ "VALUES ('"+user.getUser_name()+"', '"+user.getUser_pass()+"', '"+user.getUser_email()+"', '"+user.getUser_role()+"', '"+user.getUser_fullname()+"');";
		return jdbcTemplate.update(sql);
	}
	public boolean checkUser(String name) {
		String sql="SELECT * FROM jewelryshop.user WHERE user_name='"+name+"';";
		return _jdbcTemplate.query(sql, new MapperUser()).isEmpty();
		
	}
	public int editUser(User user) {
		String sql="UPDATE `jewelryshop`.`user` SET `user_name` = '"+user.getUser_name()+"', `user_pass` = '"+user.getUser_pass()+"', `user_email` = '"+user.getUser_email()+"', `user_phone` = '"+user.getUser_phone()+"', `user_address` = '"+user.getUser_address()+"', `user_fullname` = '"+user.getUser_fullname()+"' WHERE (`user_id` = '"+user.getUser_id()+"');";
		return jdbcTemplate.update(sql);
	}
	public User getUser(String user_name,String user_pass) {
		String sql="SELECT * FROM jewelryshop.user WHERE user_name='"+user_name+"' && user_pass='"+user_pass+"';";
	    if(_jdbcTemplate.query(sql ,new MapperUser()).isEmpty()) {
	    	return null;
	    }
		else {
			return _jdbcTemplate.query(sql ,new MapperUser()).get(0);
		}
		
	}
	public User getUser(int id) {
		String sql="SELECT * FROM jewelryshop.user WHERE user_id="+id+";";
	    if(jdbcTemplate.query(sql ,new MapperUser()).isEmpty()) {
	    	return null;
	    }
		else {
			return jdbcTemplate.query(sql ,new MapperUser()).get(0);
		}
		
	}
	public int delUser(int id) {
		String sql="DELETE FROM `jewelryshop`.`user` WHERE (`user_id` = '"+id+"');";
		
		return jdbcTemplate.update(sql);
	}
	public List<User> getUsers(){
		
		String sql="SELECT * FROM jewelryshop.user;";
		if(jdbcTemplate.query(sql, new MapperUser()).isEmpty()) {
			return null;
		}
		
		
		return jdbcTemplate.query(sql, new MapperUser());
	}

}