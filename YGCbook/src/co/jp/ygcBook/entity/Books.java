package co.jp.ygcBook.entity;

public class Books {
	
	private  String bookId;
	private String title;
	private  String author;
	private  String price;
	private  String inventory;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getInventory() {
		return inventory;
	}
	public void setInventory(String inventory) {
		this.inventory = inventory;
		
	}
	public Books(String bookId, String title, String author, String price, String inventory) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
		this.inventory = inventory;
	}
	
	
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", title=" + title + ", author=" + author + ", price=" + price
				+ ", inventory=" + inventory + "]";
	}
	public Books() {
		super();
	}
	
	
}
