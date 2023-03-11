package JewelryShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import JewelryShop.Entity.MapperOrder;
import JewelryShop.Entity.Order;
@Repository
public class OrderDao extends BaseDao {
	public List<Order> getAllOrders() {
		List<Order> list=new ArrayList<Order>();
		String sql="SELECT * FROM jewelryshop.order;";
		list=_jdbcTemplate.query(sql, new MapperOrder());
		return list;
	}

}
