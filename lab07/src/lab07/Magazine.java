package lab07;

public class Magazine implements LibraryItem{

	private String title;
	
	public Magazine(String title) {
		this.title = title;
	}
	
	@Override
	public String getDetails() {
		return "Magazine name: " + title;
	}

	@Override
	public void borrowItem() {
		System.out.println("Borrwing magazine: " + title);
	}

}
