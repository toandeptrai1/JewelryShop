package JewelryShop.Service;

import org.springframework.stereotype.Service;

import JewelryShop.Entity.Order;
import JewelryShop.Entity.OrderDetail;

@Service
public interface IBillService {
	public int addOrder(Order oder);
	public int addOrderDetal(OrderDetail orderDetail );
	public int getIdOrder(int user_id);
	public int getTotalSale();
	public double getRevenue();
	public int getCountCustomers();

}
