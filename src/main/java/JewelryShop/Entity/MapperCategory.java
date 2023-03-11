package JewelryShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCategory implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category c=new Category();
		c.setCategory_id(rs.getInt("category_id"));
		c.setCategory_name(rs.getString("category_name"));
		return c;
	}

}
