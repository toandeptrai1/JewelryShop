package JewelryShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JewelryShop.Dao.CategoryDao;
import JewelryShop.Entity.Category;
@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	CategoryDao categoryDao;

	@Override
	public List<Category> getAllCategories() {
		
		return categoryDao.getAllCategories();
	}

	@Override
	public int editCategory(Category c) {
		// TODO Auto-generated method stub
		return categoryDao.editCategory(c);
	}

	@Override
	public int delCategory(int id) {
		// TODO Auto-generated method stub
		return categoryDao.delCategory(id);
	}

	@Override
	public int addCategory(String cname) {
		// TODO Auto-generated method stub
		return categoryDao.addCategory(cname);
	}

	@Override
	public Category getCateById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.getCateById(id);
	}

}
