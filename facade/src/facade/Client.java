package facade;

public class Client {

	public static void main(String[] args) {
		
		HomeTheaterFacade homeTheater = new HomeTheaterFacade();
		homeTheater.watchMovie("The Lord of the Rings");
		System.out.println();
		homeTheater.endMovie();
	}
}
