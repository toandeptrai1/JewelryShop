package JewelryShop.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import JewelryShop.Dto.CartDto;
import JewelryShop.Entity.Order;
import JewelryShop.Entity.OrderDetail;
import JewelryShop.Entity.Product;
@Repository
public class BillDao extends BaseDao {
	@Autowired
	ProductDao productDao;
	public int addOrder(Order oder) {
		String sql="INSERT INTO `jewelryshop`.`order` (`order_user_id`, `order_amount`, `order_phone`, `order_date`, `order_ship_address`, `order_notes`)";
		sql+=" VALUES ('"+oder.getOrder_user_id()+"', '"+oder.getOrder_amount()+"', '"+oder.getOrder_phone()+"', '"+oder.getOrder_date()+"', '"+oder.getOrder_ship_address()+"', '"+oder.getOrder_notes()+"');";
		
		return _jdbcTemplate.update(sql);
	}
	public int addOrderDetal(OrderDetail orderDetail ) {
		String sql="INSERT INTO `jewelryshop`.`order_detail` (`order_detail_order_id`, `order_detail_quantity`, `order_detail_pid`, `order_detail_price`)";
		sql+=" VALUES ('"+orderDetail.getOrder_detail_order_id()+"', '"+orderDetail.getOrder_detail_quantity()+"', '"+orderDetail.getOrder_detail_pid()+"', '"+orderDetail.getOrder_detail_price()+"');";
		
		return _jdbcTemplate.update(sql);
	}
	public int getIdOrder(int user_id) {
		String sql="SELECT MAX(order_id) FROM jewelryshop.order WHERE order_user_id="+user_id+";";
		int id=_jdbcTemplate.queryForObject(sql,int.class );
		return id;
	}
	public int getTotalSale() {
		String sql="SELECT SUM(order_detail_quantity) FROM jewelryshop.order_detail;";
		return _jdbcTemplate.queryForObject(sql, int.class);
	}
	public double getRevenue() {
		String sql="SELECT SUM(order_amount) FROM jewelryshop.order;";
		return _jdbcTemplate.queryForObject(sql, double.class);
	}
	public int getCountCustomers() {
		String sql="SELECT  COUNT(distinct order_user_id)  FROM jewelryshop.order;";
		return _jdbcTemplate.queryForObject(sql, int.class);
	}

}
