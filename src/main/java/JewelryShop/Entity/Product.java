package JewelryShop.Entity;

public class Product {
	private int product_id;
	private int product_category_id; 
	private String product_img;
	private String product_name;
	private String product_price;
	private String product_short_desc;
	private String  product_long_desc;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int product_id, int product_category_id, String product_img, String product_name,
			String product_price, String product_short_desc, String product_long_desc) {
		super();
		this.product_id = product_id;
		this.product_category_id = product_category_id;
		this.product_img = product_img;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_short_desc = product_short_desc;
		this.product_long_desc = product_long_desc;
	}
	public int getProduct_id() {
		return product_id;
	}
	public int getProduct_category_id() {
		return product_category_id;
	}
	public String getProduct_img() {
		return product_img;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public String getProduct_short_desc() {
		return product_short_desc;
	}
	public String getProduct_long_desc() {
		return product_long_desc;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public void setProduct_category_id(int product_category_id) {
		this.product_category_id = product_category_id;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public void setProduct_short_desc(String product_short_desc) {
		this.product_short_desc = product_short_desc;
	}
	public void setProduct_long_desc(String product_long_desc) {
		this.product_long_desc = product_long_desc;
	}
	

}
