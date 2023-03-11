package JewelryShop.Controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import JewelryShop.Entity.Category;
import JewelryShop.Entity.Product;
import JewelryShop.Entity.User;
import JewelryShop.Service.CategoryServiceImpl;
import JewelryShop.Service.ProductServiceImpl;
import JewelryShop.Service.UserServiceImpl;
import net.htmlparser.jericho.CharacterReference;

@Controller
public class HomeController {
	@Autowired
	ProductServiceImpl productService=new ProductServiceImpl();
	@Autowired
	UserServiceImpl userService;
	@Autowired
	
	CategoryServiceImpl categoryService=new CategoryServiceImpl();
	@RequestMapping(value = {"/","/trang-chu"} ,method = RequestMethod.GET)
	public String Index(Model mv) {
		
		List<Product> list=new ArrayList<Product>();
		list=productService.getAllProduct();
		List<Category> listC=new ArrayList<Category>();
		listC=categoryService.getAllCategories();
		List<Product> listNewP=new ArrayList<Product>();
		listNewP=productService.getNewProduct();
		List<Product> listPByCate=new ArrayList<Product>();
		listPByCate=productService.getProductsByCate(1);
		mv.addAttribute("listNewP", listNewP);
		mv.addAttribute("listPByCate",listPByCate);
		mv.addAttribute("listP", list);
		mv.addAttribute("listC", listC);
		return "user/index";
	}
	@RequestMapping(value = {"/dang-nhap"} ,method = RequestMethod.GET)
	public String Login(Model mv) {
		
		return "user/uLogin";
	}
	@RequestMapping(value = {"/dang-xuat"} ,method = RequestMethod.GET)
	public String LogOut(Model mv,HttpSession session) {
		session.removeAttribute("User");
		session.removeAttribute("Cart");
		session.removeAttribute("TotalQuanty");
		session.removeAttribute("TotalPrice");
		return "redirect:/";
	}
	@RequestMapping(value = {"/dang-ky"} ,method = RequestMethod.GET)
	public String Register(Model mv) {
		
		
		return "user/uRegister";
	}
	@RequestMapping(value = {"/dang-nhap"} ,method = RequestMethod.POST)
	public String login(Model mv,HttpSession session,HttpServletRequest req) {
		
		User user=new User();
		
		String user_name=req.getParameter("username");
		String user_pass=req.getParameter("password");
		user.setUser_name(user_name);
		user.setUser_pass(user_pass);
	
		System.out.println(user_name+"**"+user_pass);
		if(userService.getUser(user_name, user_pass)!=null) {
			user=userService.getUser(user_name, user_pass);
			session.setAttribute("User", user);
			return "redirect:trang-chu";
		}else {
			mv.addAttribute("Err", "Tên đăng nhập hoặc mật khẩu không chính xác!");
			return "user/uLogin";
		}
		
		
	}
	@RequestMapping(value = {"/dang-ky"} ,method = RequestMethod.POST)
	public String register(Model mv,HttpSession session,HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		User user=new User();
		String user_fullname=req.getParameter("name");
		String user_email=req.getParameter("email");
		String user_name=req.getParameter("username");
		String user_pass=req.getParameter("password");
		user.setUser_fullname(user_fullname);
		user.setUser_email(user_email);
		user.setUser_name(user_name);
		user.setUser_pass(user_pass);
		user.setUser_role(0);
		if(user!=null && userService.checkUser(user_name)) {
			if(userService.addUser(user)>0) {
				session.setAttribute("User", user);
				return "redirect:trang-chu";
			}else {
				mv.addAttribute("Err","Tên đăng nhập đã tồn tại!");
				
				return "user/uRegister";
			}
		}else {
			mv.addAttribute("Err", "Tên đăng nhập đã tồn tại!");
			
			return "user/uRegister";
		}
		
		
	}
	@RequestMapping(value = {"/profile"} ,method = RequestMethod.GET)
	public String Profile(Model mv,HttpSession session) {
		User user=(User)session.getAttribute("User");
		if(user!=null) {
		
			user.setUser_fullname(CharacterReference.decode(user.getUser_fullname()));
			user.setUser_address(CharacterReference.decode(user.getUser_address()));
			session.setAttribute("User", user);
		}
		List<Category> listC=new ArrayList<Category>();
		listC=categoryService.getAllCategories();
		mv.addAttribute("listC", listC);
		
		return "user/profile";
	}

}
