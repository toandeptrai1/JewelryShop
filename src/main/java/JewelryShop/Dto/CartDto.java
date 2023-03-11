package JewelryShop.Dto;

import JewelryShop.Entity.Product;

public class CartDto {
	private int quantity;
	private float totalPrice;
	private Product product;
	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDto(int quantity, float totalPrice, Product product) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

}
