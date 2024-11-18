package lab07;

public class LibraryConfigManager {
	
    private static LibraryConfigManager instance;
    private double lateFees;
    private int borrowingLimit;
    private String libraryHours;

    private LibraryConfigManager() {
        this.lateFees = 10;
        this.borrowingLimit = 5;
        this.libraryHours = "10 AM - 9 PM";
    }

    public static LibraryConfigManager getInstance() {
        if (instance == null) {
            instance = new LibraryConfigManager();
        }
        return instance;
    }

    public double getLateFees() {
        return lateFees;
    }

    public void setLateFees(double lateFees) {
        this.lateFees = lateFees;
    }

    public int getBorrowingLimit() {
        return borrowingLimit;
    }

    public void setBorrowingLimit(int borrowingLimit) {
        this.borrowingLimit = borrowingLimit;
    }

    public String getLibraryHours() {
        return libraryHours;
    }

    public void setLibraryHours(String libraryHours) {
        this.libraryHours = libraryHours;
    }
}

