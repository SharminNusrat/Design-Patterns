package lab07;

public class LibraryItemFactory {

	public static LibraryItem createLibraryItem(String type, String name, String author) {
		if(type.equalsIgnoreCase("book")) {
			return new Book(name, author);
		}
		else if(type.equalsIgnoreCase("magazine")) {
			return new Magazine(name);
		}
		else return null;
	}
}
