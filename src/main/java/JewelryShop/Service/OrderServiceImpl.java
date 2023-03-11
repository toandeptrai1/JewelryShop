package JewelryShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JewelryShop.Dao.OrderDao;
import JewelryShop.Entity.Order;
@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	OrderDao orderDao;

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders();
	}

}
