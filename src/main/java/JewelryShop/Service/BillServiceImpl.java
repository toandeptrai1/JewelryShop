package JewelryShop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JewelryShop.Dao.BillDao;
import JewelryShop.Entity.Order;
import JewelryShop.Entity.OrderDetail;
@Service
public class BillServiceImpl implements IBillService {
	@Autowired 
	BillDao billDao;

	@Override
	public int addOrder(Order oder) {
		// TODO Auto-generated method stub
		return billDao.addOrder(oder);
	}

	@Override
	public int addOrderDetal(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return billDao.addOrderDetal(orderDetail);
	}

	@Override
	public int getIdOrder(int user_id) {
		// TODO Auto-generated method stub
		return billDao.getIdOrder(user_id);
	}

	@Override
	public int getTotalSale() {
		// TODO Auto-generated method stub
		return billDao.getTotalSale();
	}

	@Override
	public double getRevenue() {
		// TODO Auto-generated method stub
		return billDao.getRevenue();
	}

	@Override
	public int getCountCustomers() {
		// TODO Auto-generated method stub
		return billDao.getCountCustomers();
	}

}
