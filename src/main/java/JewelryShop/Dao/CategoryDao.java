package JewelryShop.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import JewelryShop.Entity.Category;
import JewelryShop.Entity.MapperCategory;
import JewelryShop.Entity.MapperProduct;
import JewelryShop.Entity.Product;
@Repository
public class CategoryDao extends BaseDao {
	private JdbcTemplate jdbcTemplate;
	public CategoryDao(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public CategoryDao() {
		
	}
	public List<Category> getAllCategories() {
		List<Category> list=new ArrayList<Category>();
		String sql="SELECT * FROM jewelryshop.category;";
		list=_jdbcTemplate.query(sql, new MapperCategory());
		return list;
	}
	public int editCategory(Category c) {
		String sql="UPDATE `jewelryshop`.`category` SET `category_name` = '"+c.getCategory_name()+"' WHERE (`category_id` = '"+c.getCategory_id()+"');";
		
		
		return _jdbcTemplate.update(sql);
	}
	public int  delCategory(int id) {
		String sql="DELETE FROM `jewelryshop`.`category` WHERE (`category_id` = '"+id+"');";
		String sql1="DELETE  FROM `jewelryshop`.`product` WHERE (`product_category_id` = '"+id+"');";
		_jdbcTemplate.update(sql1);
		return _jdbcTemplate.update(sql);
	}
	public int addCategory(String cname) {
		String sql="INSERT INTO `jewelryshop`.`category` (`category_name`) VALUES ('"+cname+"');";
		
		return jdbcTemplate.update(sql);
	}
	public Category getCateById(int id) {
		String sql="SELECT * FROM jewelryshop.category WHERE category_id="+id+";";
		Category c=new Category();
		c=jdbcTemplate.queryForObject(sql, new MapperCategory());
		return c;
		
	}
	public List<Product> getProductsByCate(int cid){
		List<Product> list=new ArrayList<Product>();
		String sql="SELECT * FROM jewelryshop.product WHERE product_category_id="+cid+"";
		if(_jdbcTemplate.query(sql, new MapperProduct()).isEmpty()) {
			return null;
		}else {
			list=_jdbcTemplate.query(sql, new MapperProduct());
			return list;
		}
		
	}
}
