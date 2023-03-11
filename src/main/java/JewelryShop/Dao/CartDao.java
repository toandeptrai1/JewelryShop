package JewelryShop.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import JewelryShop.Dto.CartDto;
import JewelryShop.Entity.Product;
@Repository
public class CartDao extends BaseDao {
	@Autowired
	ProductDao productDao;
	public HashMap<Integer, CartDto> AddCart(int id,HashMap<Integer, CartDto> cart){
		CartDto itemCart=new CartDto();
		Product product=productDao.getProductByID(id);
		if(product!=null&&cart.containsKey(id)) {
			itemCart=cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity()+1);
			itemCart.setTotalPrice(itemCart.getQuantity()*Float.parseFloat(itemCart.getProduct().getProduct_price()));
		}else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(Float.parseFloat(product.getProduct_price()) );
			
		}
		cart.put(id, itemCart);
		return cart;
		
	}
	public HashMap<Integer, CartDto> editCart(int id,int quanty,HashMap<Integer, CartDto> cart){
		if(cart==null) {
			return cart;
		}
		CartDto itemCart=new CartDto();
		if(cart.containsKey(id)) {
			itemCart=cart.get(id);
			itemCart.setQuantity(quanty);
			itemCart.setTotalPrice(quanty*Float.parseFloat(itemCart.getProduct().getProduct_price()));
			
		}
		cart.put(id, itemCart);
		return cart;
		
	}
	public HashMap<Integer, CartDto> delCart(int id,HashMap<Integer, CartDto> cart){
		if(cart==null) {
			return cart;
		}
		
		if(cart.containsKey(id)) {
			cart.remove(id);
			
		}
		
		return cart;
		
	}
	public int totalQuanty(HashMap<Integer, CartDto> cart) {
		int totalQuanty=0;
		for (Map.Entry<Integer,CartDto> itemCart : cart.entrySet()) {
			totalQuanty+=itemCart.getValue().getQuantity();
		
			
		}
		return totalQuanty;
		
	}
	public double totalPrice(HashMap<Integer, CartDto> cart) {
		int totalPrice=0;
		for (Map.Entry<Integer,CartDto> itemCart : cart.entrySet()) {
			totalPrice+=itemCart.getValue().getTotalPrice();
			
		}
		return totalPrice;
		
	}
	

}
