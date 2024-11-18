package lab07;

public class Book implements LibraryItem{
	private String bookName;
	private String author;
	
	public Book(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}
	
	@Override
	public String getDetails() {
		return "Book name: " + bookName + " Author: " + author;
	}
	
	@Override
	public void borrowItem() {
		System.out.println("Borrowing book- " + bookName);
	}
}
