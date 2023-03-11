package JewelryShop.Entity;

public class User {
	private int user_id;
	private String user_name;
	private String user_pass;
	private String user_img;
	private String user_email;
	private int user_role;
	private String user_phone;
	private String user_address;
	private String user_fullname;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id, String user_name, String user_pass, String user_img, String user_email, int user_role,
			String user_phone, String user_address, String user_fullname) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.user_img = user_img;
		this.user_email = user_email;
		this.user_role = user_role;
		this.user_phone = user_phone;
		this.user_address = user_address;
		this.user_fullname = user_fullname;
	}

	public int getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public String getUser_img() {
		return user_img;
	}

	public String getUser_email() {
		return user_email;
	}

	public int getUser_role() {
		return user_role;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

	public String getUser_fullname() {
		return user_fullname;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}
	
	

}
