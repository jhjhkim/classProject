package object;

public class Book {
	private int		bookid;
	private String  bookName;	 
	private int 	price;		 
	private String  writer;		 
	private String  publisher;
	private int  category;	 
	private int	stock;		 
	
	public Book(int bookid, String bookName, int price, String writer, String publisher, int category,int stock) {
		this.bookid = bookid;
		this.bookName = bookName;
		this.price = price;
		this.writer = writer;
		this.publisher = publisher;
		this.category = category;
		this.stock = stock;
	}
	
	public Book(String bookName, int price, String writer, String publisher, int category,int stock) {
		this.bookName = bookName;
		this.price = price;
		this.writer = writer;
		this.publisher = publisher;
		this.category = category;
		this.stock = stock;
	}
	

	public Book() {
	}


	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", price=" + price + ", writer=" + writer
				+ ", publisher=" + publisher + ", category=" + category + ", stock=" + stock + "]";
	}

	public void basicInfo() {
		System.out.println("No. " + bookid + "\t제목: " + bookName + "\t가격: " + price);
	}
	
	public void showInfo() {
		System.out.println("NO. " + bookid + "\t\t제목: " + bookName);
		System.out.println("지은이: " + writer + "\t출판사: " + publisher);
	}
	
}	
