package JewelryShop.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import JewelryShop.Entity.Category;
import JewelryShop.Entity.Product;
import JewelryShop.Service.CategoryServiceImpl;
import JewelryShop.Service.ProductServiceImpl;

@Controller
public class ProductController {
	@Autowired
	ProductServiceImpl productService=new ProductServiceImpl();
	@Autowired
	CategoryServiceImpl categoryService=new CategoryServiceImpl();
	@RequestMapping(value = {"/product"} ,method = RequestMethod.GET)
	public String Index(Model mv,@RequestParam("pid") int pid) {
		Product p=new Product();
		p=productService.getProductByID(pid);
		List<Category> listC=new ArrayList<Category>();
		listC=categoryService.getAllCategories();
		mv.addAttribute("Product", p);
		mv.addAttribute("listC", listC);
		return "user/product";
	}
	

}
