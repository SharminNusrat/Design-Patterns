package composite;

public class Client {
	public static void main(String[] args) {
		FileSystem file1 = new File("file1.txt");
		FileSystem file2 = new File("file2.txt");
		FileSystem file3 = new File("file3.txt");
		
		Directory dir1 = new Directory("dir1");
		Directory dir2 = new Directory("dir2");
		
		dir1.add(file1);
		dir1.add(file2);
		
		dir2.add(file3);
		dir2.add(dir1);
		
		dir2.display("");
	}
}
