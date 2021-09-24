package srikanth;

class Books {

	int isbn;
	String title;
	double price;

	public Books(int isbn, String title, double price) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;

	}

	public void display() {
		System.out.println("isbn: " + isbn + "  " + "title: " + title + "  " + "price: " + price);
	}

}

class Novel extends Books {
	String author;

	public Novel(int isbn, String title, double price, String author) {
		super(isbn, title, price);
		this.author = author;

	}

	public void display() {
		System.out.println(
				"isbn: " + isbn + "  " + "title: " + title + "  " + "price: " + price + "  " + "author: " + author);
	}

}

class Magazine extends Books {
	String type;

	public Magazine(int isbn, String title, double price, String type) {
		super(isbn, title, price);
		this.type = type;

	}

	public void display() {
		System.out.println(
				"isbn: " + isbn + "  " + "title: " + title + "  " + "price: " + price + "  " + "type: " + type);
	}

}

public class AssConstructor {
	public static void main(String[] args) {
		Magazine mag = new Magazine(1, "times of india", 1250.00, "monthly");
		mag.display();

	}
}
