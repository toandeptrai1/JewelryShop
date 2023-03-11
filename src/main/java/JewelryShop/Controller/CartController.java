package JewelryShop.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import JewelryShop.Dto.CartDto;
import JewelryShop.Entity.Category;
import JewelryShop.Entity.Product;
import JewelryShop.Service.CartServiceImpl;
import JewelryShop.Service.CategoryServiceImpl;
import JewelryShop.Service.ProductServiceImpl;

@Controller
public class CartController {
	@Autowired
	ProductServiceImpl productService=new ProductServiceImpl();
	@Autowired
	CartServiceImpl cartService;
	@Autowired
	CategoryServiceImpl categoryService=new CategoryServiceImpl();
	@RequestMapping(value = {"/cart"} ,method = RequestMethod.GET)
	public String Index(Model mv) {
		
		List<Category> listC=new ArrayList<Category>();
		listC=categoryService.getAllCategories();
		
		mv.addAttribute("listC", listC);
		return "user/cart";
	}
	@RequestMapping(value = {"/cart/add/{id}"} )
	public String Addcart(HttpServletRequest res,HttpSession session,@PathVariable int id) {
		HashMap<Integer, CartDto> cart=(HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if(cart==null) {
			cart=new HashMap<Integer, CartDto>();
		}
		cart=cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuanty", cartService.totalQuanty(cart));
		session.setAttribute("TotalPrice",String.format("%.0f", cartService.totalPrice(cart)) );
		return "redirect:"+res.getHeader("Referer");
	}
	@RequestMapping(value = {"/cart/edit/{id}/{quanty}"} )
	public String EditCart(HttpServletRequest res,HttpSession session,@PathVariable int id,@PathVariable int quanty) {
		HashMap<Integer, CartDto> cart=(HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if(cart==null) {
			cart=new HashMap<Integer, CartDto>();
		}
		cart=cartService.editCart(id, quanty, cart);
		
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuanty", cartService.totalQuanty(cart));
		session.setAttribute("TotalPrice",String.format("%.0f", cartService.totalPrice(cart)) );
		return "redirect:"+res.getHeader("Referer");
	}
	@RequestMapping(value = {"/cart/delete/{id}"} )
	public String DeleteCart(HttpServletRequest res,HttpSession session,@PathVariable int id) {
		HashMap<Integer, CartDto> cart=(HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if(cart==null) {
			cart=new HashMap<Integer, CartDto>();
		}
		cart=cartService.delCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuanty", cartService.totalQuanty(cart));
		session.setAttribute("TotalPrice",String.format("%.0f", cartService.totalPrice(cart)) );
		return "redirect:"+res.getHeader("Referer");
	}

}
