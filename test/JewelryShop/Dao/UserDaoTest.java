package JewelryShop.Dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import JewelryShop.Entity.User;

class UserDaoTest {
	private DriverManagerDataSource dataSource;
	

	@Test
	void testAddUser() {
		User user=new User();
		user.setUser_name("xuan bach");
		user.setUser_pass("123456789");
		user.setUser_role(0);
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jewelryshop");
		dataSource.setUsername("root");
		dataSource.setPassword("123456789");
		UserDao userDao=new UserDao(dataSource);
		assertTrue(userDao.addUser(user)>0);
		
	}

	

	@Test
	void testEditUser() {
		User user=new User();
		user.setUser_id(0);
		user.setUser_name("djksadjsadasbdjasdqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		user.setUser_pass("123456789551121");
		user.setUser_role(0);
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jewelryshop");
		dataSource.setUsername("root");
		dataSource.setPassword("123456789");
		UserDao userDao=new UserDao(dataSource);
		assertTrue(userDao.editUser(user)>0);
	}

	
	@Test
	void testGetUserInt() {
		int id=1;
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jewelryshop");
		dataSource.setUsername("root");
		dataSource.setPassword("123456789");
		UserDao userDao=new UserDao(dataSource);
		assertNotNull(userDao.getUser(id));
	}

	@Test
	void testDelUser() {
		int id=11;
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jewelryshop");
		dataSource.setUsername("root");
		dataSource.setPassword("123456789");
		UserDao userDao=new UserDao(dataSource);
		assertTrue(userDao.delUser(id)>0);
	}

	@Test
	void testGetUsers() {
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jewelryshop");
		dataSource.setUsername("root");
		dataSource.setPassword("123456789");
		UserDao userDao=new UserDao(dataSource);
		assertNotNull(userDao.getUsers());
	}

}
