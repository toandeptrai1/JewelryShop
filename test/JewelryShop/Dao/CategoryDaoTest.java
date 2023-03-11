package JewelryShop.Dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import JewelryShop.Entity.Category;

class CategoryDaoTest  {
	private DriverManagerDataSource dataSource;
	

	@Test
	void testGetAllCategories() {
		
	}

	@Test
	void testEditCategory() {
		fail("Not yet implemented");
	}

	@Test
	void testDelCategory() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCategory() {
		String cname="Vong co namjasggfjhgdhdgasjgdhjhajajaajajajajjjjjjjjjjjjjjjjjjjjjjjlllllladjahdjakhdaaaaaaaaaaaaaaaadsaaaaaaaaa";
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jewelryshop");
		dataSource.setUsername("root");
		dataSource.setPassword("123456789");
		CategoryDao cateDao=new CategoryDao(dataSource);
		int result=cateDao.addCategory(cname);
		assertTrue(result>0);
	}

	@Test
	void testGetCateById() {
		int id=7;
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jewelryshop");
		dataSource.setUsername("root");
		dataSource.setPassword("123456789");
		CategoryDao cateDao=new CategoryDao(dataSource);
		Category cate=cateDao.getCateById(id);
		assertNotNull(cate);
		
	}

	@Test
	void testGetProductsByCate() {
		fail("Not yet implemented");
	}

}
