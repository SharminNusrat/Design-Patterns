package lab07;

public class Main {
    public static void main(String[] args) {
        
        LibraryItem book = LibraryItemFactory.createLibraryItem("book", "A Thousand Splendid Suns", "Khaled Husseini");
        LibraryItem magazine = LibraryItemFactory.createLibraryItem("magazine", "Zero to Infinity",null);

        RealLibraryAccess realAccess = new RealLibraryAccess();
        realAccess.addItem("B-01", book);
        realAccess.addItem("M-01", magazine);

        LibraryAccess proxyAccess = new LibraryAccessProxy(realAccess);

        User admin = new User("Admin", true);
        User user1 = new User("User1", false);
        User user2 = new User("User2", true);

        proxyAccess.accessItem("B-01", admin); 
        proxyAccess.accessItem("M-01", user1); 
        proxyAccess.accessItem("M-01", user2);

        LibraryConfigManager config = LibraryConfigManager.getInstance();
        System.out.println("Library Hours: " + config.getLibraryHours());
        config.setLateFees(5.0);
        System.out.println("Late Fees: " + config.getLateFees());
    }
}