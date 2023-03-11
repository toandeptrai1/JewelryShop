package JewelryShop.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import JewelryShop.Dto.CartDto;

@Service
public interface ICartService {
	public HashMap<Integer, CartDto> AddCart(int id,HashMap<Integer, CartDto> cart);
	public HashMap<Integer, CartDto> editCart(int id,int quanty,HashMap<Integer, CartDto> cart);
	public HashMap<Integer, CartDto> delCart(int id,HashMap<Integer, CartDto> cart);
	public int totalQuanty(HashMap<Integer, CartDto> cart);
	public double totalPrice(HashMap<Integer, CartDto> cart);
	

}
