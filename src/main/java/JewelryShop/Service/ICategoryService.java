package JewelryShop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import JewelryShop.Entity.Category;

@Service
public interface ICategoryService {
	public List<Category> getAllCategories();
	public int editCategory(Category c);
	public int  delCategory(int id);
	public int addCategory(String cname);
	public Category getCateById(int id);
	

}
