package JewelryShop.Controller.Admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import JewelryShop.Entity.Category;
import JewelryShop.Entity.MyFile;
import JewelryShop.Entity.Order;
import JewelryShop.Entity.Product;
import JewelryShop.Entity.User;
import JewelryShop.Service.BillServiceImpl;
import JewelryShop.Service.CategoryServiceImpl;
import JewelryShop.Service.OrderServiceImpl;
import JewelryShop.Service.ProductServiceImpl;
import JewelryShop.Service.UserServiceImpl;

@Controller
public class AdminController {
	@Autowired
	BillServiceImpl billService;
	@Autowired
	UserServiceImpl userService;
	@Autowired
	ProductServiceImpl productService;
	@Autowired
	CategoryServiceImpl categoryService=new CategoryServiceImpl();
	@Autowired
	OrderServiceImpl orderService;
	@RequestMapping(value = {"/quan-tri/"} ,method = RequestMethod.GET)
	public String Index(Model mv,HttpSession session) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			mv.addAttribute("totalSale", billService.getTotalSale());
			mv.addAttribute("Revenue", String.format("%.0f", billService.getRevenue()) );
			mv.addAttribute("myFile", new MyFile());
		
			mv.addAttribute("CountCustomer", billService.getCountCustomers());
			return "admin/index";
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/user/view"} ,method = RequestMethod.GET)
	public String userView(Model mv,HttpSession session) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			List<User> listUser=new ArrayList<User>();
			listUser=userService.getUsers();
			if (listUser!=null) {
				mv.addAttribute("listUser", listUser);
			}
			return "admin/userView";
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/category/view"} ,method = RequestMethod.GET)
	public String cateView(Model mv,HttpSession session) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			List<Category> listCategory=new ArrayList<Category>();
			listCategory=categoryService.getAllCategories();
			System.out.println(listCategory);
			if (listCategory!=null) {
				mv.addAttribute("listCate", listCategory);
			}
			return "admin/category";
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/order/view"} ,method = RequestMethod.GET)
	public String orderView(Model mv,HttpSession session) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			List<Order> listOrder=new ArrayList<Order>();
		
			listOrder=orderService.getAllOrders();
		
			
			if (listOrder!=null) {
				mv.addAttribute("listOrder", listOrder);
			}
			return "admin/order";
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/user/profile"} ,method = RequestMethod.GET)
	public String ViewProfile(Model mv,HttpSession session,@RequestParam("id")int id) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			if(id>0) {
				User userEdit=new User();
				userEdit=userService.getUser(id);
				mv.addAttribute("userEdit", userEdit);
				return "admin/profile";
			}
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/user/edit"} ,method = RequestMethod.POST)
	public String EditUser(Model mv,HttpSession session,HttpServletRequest req ) {
		int id=Integer.parseInt(req.getParameter("id"));
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			if(id>0) {
				User userEdit=new User();
				userEdit=userService.getUser(id);
				userEdit.setUser_fullname(req.getParameter("fullName"));
				userEdit.setUser_address(req.getParameter("address"));
				userEdit.setUser_email(req.getParameter("email"));
				userEdit.setUser_phone(req.getParameter("phone"));
				if(userService.editUser(userEdit)>0) {
					return "redirect:/quan-tri/user/view";
				}else {
					return "redirect:/quan-tri/user/profile?id="+id+"";
				}
				
				
			}else {
				return "redirect:/";
			}
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/user/delete"} ,method = RequestMethod.GET)
	public String delUser(Model mv,HttpSession session,@RequestParam("id")int id) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			if(id>0) {
				if(userService.delUser(id)>0) {
					return "redirect:/quan-tri/user/view";
				}else {
					return "redirect:/quan-tri/user/view";
				}
			}
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	
	
	@RequestMapping(value = {"/quan-tri/user/add"} ,method = RequestMethod.POST)
	public String addUser(Model mv,HttpSession session,HttpServletRequest req) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
		  User userAdd=new User();
		  userAdd.setUser_fullname(req.getParameter("fullname"));
		  userAdd.setUser_address(req.getParameter("address"));
		  userAdd.setUser_name(req.getParameter("username"));
		  userAdd.setUser_email(req.getParameter("email"));
		  userAdd.setUser_pass(req.getParameter("pass"));
		  userAdd.setUser_role(Integer.parseInt(req.getParameter("role")));
		  if(userService.addUser(userAdd)>0) {
			  return "redirect:/quan-tri/user/view";
		  }
		  return "redirect:/quan-tri/user/view";
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/user/add"} ,method = RequestMethod.GET)
	public String formAdd(Model mv,HttpSession session,HttpServletRequest req) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			return "admin/AddUser";
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/product/view"} ,method = RequestMethod.GET)
	public String ProductViews(Model mv,HttpSession session,HttpServletRequest req) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			List<Product> listP=new ArrayList<Product>();
			listP=productService.getNewProduct();
			
			mv.addAttribute("ListP", listP);
			
			
			return "admin/Product";
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/product/edit"} ,method = RequestMethod.GET)
	public String ProductDetail(Model mv,HttpSession session,HttpServletRequest req,@RequestParam("id")int id) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			Product p=new Product();
			p=productService.getProductByID(id);
			if(p!=null) {
				mv.addAttribute("Product", p);
			}
			if(session.getAttribute("IdOfProduct")!=null) {
				int IDOfProductEdited=(int) session.getAttribute("IdOfProduct");
				System.out.println(session.getAttribute("IDOfProductEdited"));
				if(id!=IDOfProductEdited) {
					session.removeAttribute("FileName");
				}
				
			}else {
				session.removeAttribute("FileName");
			}
			List<Category> listC=new ArrayList<Category>();
			listC=categoryService.getAllCategories();
		
			mv.addAttribute("listC", listC);
		
			
			
			return "admin/ProductDetail";
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/product/edit"} ,method = RequestMethod.POST)
	public String EditProduct(Model mv,HttpSession session,HttpServletRequest req,@RequestParam("id")int id) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			Product p=new Product();
			p.setProduct_category_id(Integer.parseInt(req.getParameter("cateID")));
			p.setProduct_name(req.getParameter("pname"));
			p.setProduct_price(req.getParameter("price"));
			p.setProduct_long_desc(req.getParameter("desc"));
			p.setProduct_id(id);
			p.setProduct_img(req.getParameter("img"));
		
			if(p!=null&&productService.updateProduct(p)>0) {
				session.removeAttribute("FileName");
				
			
			}
			
			
			
			return "redirect:"+req.getHeader("Referer");
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/product/add"} ,method = RequestMethod.GET)
	public String addProductForm(Model mv,HttpSession session,HttpServletRequest req) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			
			
			
			return "admin/AddProduct";
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/product/add"} ,method = RequestMethod.POST)
	public String AddProduct(Model mv,HttpSession session,HttpServletRequest req) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			Product p=new Product();
			p.setProduct_category_id(Integer.parseInt(req.getParameter("cateID")));
			p.setProduct_name(req.getParameter("pname"));
			p.setProduct_price(req.getParameter("price"));
			p.setProduct_long_desc(req.getParameter("desc"));
			
			p.setProduct_img(req.getParameter("img"));
			System.out.println(p.getProduct_category_id());
		
			if(p!=null&&productService.insertProduct(p)>0) {
				session.removeAttribute("FileName");
				
			
			}
			
			
			
			return "redirect:/quan-tri/product/view";
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/product/uploadFile"} ,method = RequestMethod.POST)
	public String ProductUploadFile(Model mv,HttpSession session,HttpServletRequest req,@RequestParam("multipartFile")MultipartFile File,@RequestParam("id")int id) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			 try {
			     ServletContext context=session.getServletContext();
			     String path = context.getRealPath("/assets/images");  
			      MultipartFile multipartFile=File;
			      String fileName = multipartFile.getOriginalFilename();
			      byte[] bytes = File.getBytes();  
			      BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  new File(path+ "\\"+fileName)));  
			      stream.write(bytes);  
			      stream.flush();  
			      stream.close();  
			      session.setAttribute("FileName", fileName);
			      session.setAttribute("IdOfProduct", id);
			      
			    
			    } catch (Exception e) {
			      e.printStackTrace();
			     
			    }
			
			
			
			return "redirect:"+req.getHeader("Referer");
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/product/delete"} ,method = RequestMethod.GET)
	public String DeleteProduct(Model mv,HttpSession session,HttpServletRequest req,@RequestParam("id")int id) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			if(id>0) {
				if(productService.delProduct(id)>0) {
					return "redirect:/quan-tri/product/view";
				}else {
					return "redirect:/quan-tri/product/view";
				}
			}
			
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/category/delete"} ,method = RequestMethod.GET)
	public String DeleteCate(Model mv,HttpSession session,HttpServletRequest req,@RequestParam("id")int id) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			if(id>0) {
				if(categoryService.delCategory(id)>0) {
					return "redirect:/quan-tri/product/view";
				}else {
					return "redirect:/quan-tri/category/view";
				}
			}
			
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/category/edit"} ,method = RequestMethod.GET)
	public String EditCate(Model mv,HttpSession session,HttpServletRequest req,@RequestParam("id")int id) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			if(id>0) {
				Category c=new Category();
				c=categoryService.getCateById(id);
				if(c!=null) {
					mv.addAttribute("Category",c);
					return "admin/EditCate";
				}
			}
			
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/category/edit"} ,method = RequestMethod.POST)
	public String EditCateById(Model mv,HttpSession session,HttpServletRequest req,@RequestParam("id")int id) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			if(id>0) {
				Category c=new Category();
				c=categoryService.getCateById(id);
				if(c!=null) {
					c.setCategory_name(req.getParameter("pname"));
					categoryService.editCategory(c);
					
					return "redirect:/quan-tri/category/view";
				}
			}
			
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/category/add"} ,method = RequestMethod.GET)
	public String AddCateView(Model mv,HttpSession session,HttpServletRequest req) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			
			return "admin/AddCate";
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}
	@RequestMapping(value = {"/quan-tri/category/add"} ,method = RequestMethod.POST)
	public String AddCate(Model mv,HttpSession session,HttpServletRequest req) {
		User user=(User)session.getAttribute("User");
		if(user!=null&&user.getUser_role()==1) {
			
			Category c=new Category();
			if(req.getParameter("pname")!=null&&!req.getParameter("pname").equalsIgnoreCase("")) {
				c.setCategory_name(req.getParameter("pname"));
				categoryService.addCategory(c.getCategory_name());
				return "redirect:/quan-tri/category/view";
				
			}
			else {
				return "redirect:/quan-tri/category/view";
			}
			
			
		}
		if(user!=null&&user.getUser_role()!=1) {
			return "redirect:/";
		}
		return "redirect:/dang-nhap";
	}

}
