package lab08;

public class Client {
	public static void main(String[] args) {
		File file1 = new File("file1.txt", "Alice was not a bit hurt, and she jumped up on to her feet in a moment");
		File file2 = new File("file2.txt", "This is a simple file containing C code");
		File file3 = new File("file3.txt", "Alice opened the door and found that it led into a small passage, not much larger than a rat-hole");
		File file4 = new File("file4.txt", "This is a file of Python code");
		
		Folder folder1 = new Folder("folder1");
		Folder folder2 = new Folder("folder2");
		
		folder1.addComponent(file1);
		folder1.addComponent(file3);
		folder2.addComponent(folder1);
		folder2.addComponent(file2);
		
		folder2.search("door");
		System.out.println();
		folder1.search("Alice");
		file2.search("C code");
	}
}
