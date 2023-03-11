package JewelryShop.Service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JewelryShop.Dao.CartDao;
import JewelryShop.Dto.CartDto;
@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	CartDao cartDao;

	@Override
	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart) {
		
		return cartDao.AddCart(id, cart);
	}

	@Override
	public HashMap<Integer, CartDto> editCart(int id, int quanty, HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.editCart(id, quanty, cart);
	}

	@Override
	public HashMap<Integer, CartDto> delCart(int id, HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.delCart(id, cart);
	}

	@Override
	public int totalQuanty(HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.totalQuanty(cart);
	}

	@Override
	public double totalPrice(HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.totalPrice(cart);
	}

}
