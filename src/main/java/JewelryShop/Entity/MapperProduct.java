package JewelryShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProduct implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Product p=new Product();
		p.setProduct_id(rs.getInt("product_id"));
		p.setProduct_category_id(rs.getInt("product_category_id"));
		p.setProduct_img(rs.getString("product_img"));
		p.setProduct_name(rs.getString("product_name"));
		p.setProduct_price(rs.getString("product_price"));
		p.setProduct_short_desc(rs.getString("product_short_desc"));
		p.setProduct_long_desc(rs.getString("product_long_desc"));
		return p;
	}

}
