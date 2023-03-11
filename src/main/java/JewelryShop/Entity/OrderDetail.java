package JewelryShop.Entity;

public class OrderDetail {
	private int order_detail_id;
	private int order_detail_order_id;
	private int order_detail_quantity;
	private int order_detail_pid;
	private float order_detail_price;
	
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int order_detail_id, int order_detail_order_id, int order_detail_quantity, int order_detail_pid,
			float order_detail_price) {
		super();
		this.order_detail_id = order_detail_id;
		this.order_detail_order_id = order_detail_order_id;
		this.order_detail_quantity = order_detail_quantity;
		this.order_detail_pid = order_detail_pid;
		this.order_detail_price = order_detail_price;
	}

	public int getOrder_detail_id() {
		return order_detail_id;
	}

	public int getOrder_detail_order_id() {
		return order_detail_order_id;
	}

	public int getOrder_detail_quantity() {
		return order_detail_quantity;
	}

	public int getOrder_detail_pid() {
		return order_detail_pid;
	}

	public float getOrder_detail_price() {
		return order_detail_price;
	}

	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public void setOrder_detail_order_id(int order_detail_order_id) {
		this.order_detail_order_id = order_detail_order_id;
	}

	public void setOrder_detail_quantity(int order_detail_quantity) {
		this.order_detail_quantity = order_detail_quantity;
	}

	public void setOrder_detail_pid(int order_detail_pid) {
		this.order_detail_pid = order_detail_pid;
	}

	public void setOrder_detail_price(float order_detail_price) {
		this.order_detail_price = order_detail_price;
	}
	

}
