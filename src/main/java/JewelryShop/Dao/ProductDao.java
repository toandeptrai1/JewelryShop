package JewelryShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import JewelryShop.Entity.MapperProduct;
import JewelryShop.Entity.Product;

@Repository
public class ProductDao extends BaseDao {
	public List<Product> getAllProduct(){
		List<Product> list=new ArrayList<Product>();
		String sql="SELECT * FROM jewelryshop.product;";
		list=_jdbcTemplate.query(sql, new MapperProduct());
		return list;
	}
	
	public List<Product> getNewProduct(){
		List<Product> list=new ArrayList<Product>();
		String sql="SELECT * FROM jewelryshop.product ORDER BY product_id DESC LIMIT 8;";
		list=_jdbcTemplate.query(sql, new MapperProduct());
		return list;
	}
	public List<Product> getProductsByCate(int cid){
		List<Product> list=new ArrayList<Product>();
		String sql="SELECT * FROM jewelryshop.product WHERE product_category_id="+cid+"";
		list=_jdbcTemplate.query(sql, new MapperProduct());
		return list;
	}
	public Product getProductByID(int id) {
		Product p=new Product();
		String sql="SELECT * FROM jewelryshop.product WHERE product_id="+id+";";
		p=_jdbcTemplate.queryForObject(sql, new MapperProduct());
		return p;
	}
	public int delProduct(int id) {
		String sql="DELETE FROM `jewelryshop`.`product` WHERE (`product_id` = '"+id+"');";
		
		return _jdbcTemplate.update(sql);
	}
	public int updateProduct(Product product) {
		String sql="UPDATE `jewelryshop`.`product` SET `product_category_id` = '"+product.getProduct_category_id()+"', `product_img` = '"+product.getProduct_img()+"', `product_name` = '"+product.getProduct_name()+"', `product_price` = '"+product.getProduct_price()+"', `product_short_desc` = '"+product.getProduct_short_desc()+"', `product_long_desc` = '"+product.getProduct_long_desc()+"' WHERE (`product_id` = '"+product.getProduct_id()+"');";
		
		return _jdbcTemplate.update(sql);
	}
	public int insertProduct(Product product) {
		String sql="INSERT INTO `jewelryshop`.`product` (`product_category_id`, `product_img`, `product_name`, `product_price`, `product_long_desc`) VALUES ('"+product.getProduct_category_id()+"', '"+product.getProduct_img()+"', '"+product.getProduct_name()+"', '"+product.getProduct_price()+"', '"+product.getProduct_long_desc()+"');";
		
		return _jdbcTemplate.update(sql);
	}

}
