package lab08;

public class File implements FileSystem{

	private String name;
	private String content;
	
	public File(String name, String content) {
		this.name = name;
		this.content = content;
	}
	
	@Override
	public void search(String key) {
		if(content.contains(key)) {
			System.out.println("Keyword '" + key + "' has been found in the file '" + this.name + "'.");
		}
		else {
			System.out.println("Keyword '" + key + "' has not been found in the file '" + this.name + "'.");
		}
	}
}
