package JewelryShop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import JewelryShop.Entity.User;

@Service
public interface IUserService {
	public int addUser(User user);
	public boolean checkUser(String name);
	public User getUser(String user_name,String user_pass);
	public int editUser(User user);
	public List<User> getUsers();
	public User getUser(int id);
	public int delUser(int id);

}
