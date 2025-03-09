package access_control_proxy;

public class Main {
	public static void main(String[] args) {
        // Create a proxy for a private file owned by "user1"
        File file = new ProxyFile("secret_document.txt", "user1");

        // Simulate access attempts by different users
        file.access("user1"); // Authorized: Owner accesses the file
        file.access("admin"); // Authorized: Admin accesses the file
        file.access("user2"); // Unauthorized: Access denied
    }
}
