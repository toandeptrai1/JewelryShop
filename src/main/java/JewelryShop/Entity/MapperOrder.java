package JewelryShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperOrder implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order=new Order();
		order.setOrder_id(rs.getInt("order_id"));
		order.setOrder_user_id(rs.getInt("order_user_id"));
		order.setOrder_amount(rs.getDouble("order_amount"));
		order.setOrder_phone(rs.getString("order_phone"));
		order.setOrder_date(rs.getString("order_date"));
		order.setOrder_ship_address(rs.getString("order_ship_address"));
		order.setOrder_notes(rs.getString("order_notes"));

		return order;
	}

}
