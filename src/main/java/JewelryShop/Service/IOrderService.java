package JewelryShop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import JewelryShop.Entity.Order;

@Service
public interface IOrderService {
	public List<Order> getAllOrders();

}
