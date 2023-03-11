package JewelryShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JewelryShop.Dao.UserDao;
import JewelryShop.Entity.User;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserDao userDao;

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public boolean checkUser(String name) {
		// TODO Auto-generated method stub
		return userDao.checkUser(name);
	}

	@Override
	public User getUser(String user_name, String user_pass) {
		// TODO Auto-generated method stub
		return userDao.getUser(user_name, user_pass);
	}

	@Override
	public int editUser(User user) {
		// TODO Auto-generated method stub
		return userDao.editUser(user);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public int delUser(int id) {
		// TODO Auto-generated method stub
		return userDao.delUser(id);
	}

}
