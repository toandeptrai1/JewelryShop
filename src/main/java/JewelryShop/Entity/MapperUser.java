package JewelryShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUser implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u=new User();
		u.setUser_id(rs.getInt("user_id"));
		u.setUser_name(rs.getString("user_name"));
		u.setUser_pass(rs.getString("user_pass"));
		u.setUser_img(rs.getString("user_img"));
		u.setUser_email(rs.getString("user_email"));
		u.setUser_role(rs.getInt("user_role"));
		u.setUser_phone(rs.getString("user_phone"));
		u.setUser_address(rs.getString("user_address"));
		u.setUser_fullname(rs.getString("user_fullname"));
		return u;
	}

}
