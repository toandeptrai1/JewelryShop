package JewelryShop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import JewelryShop.Entity.Product;
@Service
public interface IProductService {
	public List<Product> getAllProduct();
	public List<Product> getNewProduct();
	public List<Product> getProductsByCate(int cid);
	public Product getProductByID(int id);
	public int delProduct(int id);
	public int updateProduct(Product product);
	public int insertProduct(Product product);

}
