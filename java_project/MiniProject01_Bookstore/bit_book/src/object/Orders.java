package object;

public class Orders {
	
	private int orderId;
	private int userId;
	private int bookId;
	private String bookName;
	private int price;
	private String orderdate;
	
	public Orders() {}

	public Orders(int orderId, int userId, int bookId, String bookName, int price, String orderdate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.orderdate = orderdate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String admin() {
		return orderId + "\t" + userId + "\t" + bookId + "\t" + price + "원\t" + orderdate;
	}
	
	public String user() {
		return orderId + "\t" + bookName + "\t" + price + "원\t" + orderdate;
	}

}
