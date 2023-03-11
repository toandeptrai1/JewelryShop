package JewelryShop.Entity;

public class Order {
	private int order_id;
	private int order_user_id;
	private double order_amount;
	private String order_phone;
	private String order_date;
	private String  order_ship_address;
	private String order_notes;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Order(int order_id, int order_user_id, double order_amount, String order_phone, String order_date,
			String order_ship_address, String order_notes) {
		super();
		this.order_id = order_id;
		this.order_user_id = order_user_id;
		this.order_amount = order_amount;
		this.order_phone = order_phone;
		this.order_date = order_date;
		this.order_ship_address = order_ship_address;
		this.order_notes = order_notes;
	}


	public int getOrder_id() {
		return order_id;
	}

	public int getOrder_user_id() {
		return order_user_id;
	}

	public double getOrder_amount() {
		return order_amount;
	}

	public String getOrder_phone() {
		return order_phone;
	}

	public String getOrder_date() {
		return order_date;
	}

	public String getOrder_ship_address() {
		return order_ship_address;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public void setOrder_user_id(int order_user_id) {
		this.order_user_id = order_user_id;
	}

	public void setOrder_amount(double order_amount) {
		this.order_amount = order_amount;
	}

	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public void setOrder_ship_address(String order_ship_address) {
		this.order_ship_address = order_ship_address;
	}

	public String getOrder_notes() {
		return order_notes;
	}

	public void setOrder_notes(String order_notes) {
		this.order_notes = order_notes;
	}
	

}
