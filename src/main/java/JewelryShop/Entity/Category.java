package JewelryShop.Entity;

import java.io.Serializable;

public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 783475938676457335L;
	private int category_id;
	private String category_name;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	

}
