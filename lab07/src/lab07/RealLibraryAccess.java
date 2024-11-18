package lab07;

import java.util.HashMap;
import java.util.Map;

public class RealLibraryAccess implements LibraryAccess{

	private Map<String, LibraryItem> libraryItems = new HashMap<>();
	
	public void addItem(String itemID, LibraryItem item) {
        libraryItems.put(itemID, item);
    }
	
	@Override
    public void accessItem(String itemID, User user) {
        LibraryItem item = libraryItems.get(itemID);
        if (item != null) {
            System.out.println(user.getName() + " is accessing: " + item.getDetails());
        } else {
            System.out.println("Item not found.");
        }
    }
}
