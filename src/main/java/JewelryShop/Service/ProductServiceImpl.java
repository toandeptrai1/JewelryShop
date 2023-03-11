package JewelryShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JewelryShop.Dao.ProductDao;
import JewelryShop.Entity.Product;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductDao productDao=new ProductDao();

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

	@Override
	public List<Product> getNewProduct() {
		// TODO Auto-generated method stub
		return productDao.getNewProduct();
	}

	@Override
	public List<Product> getProductsByCate(int cid) {
		// TODO Auto-generated method stub
		return productDao.getProductsByCate(cid);
	}

	@Override
	public Product getProductByID(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductByID(id);
	}

	@Override
	public int delProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.delProduct(id);
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.insertProduct(product);
	}

}
