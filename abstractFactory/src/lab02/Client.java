package lab02;

public class Client {

	public static void main(String[] args) {
		
		FurnitureFactory modernFurnitureFactory = new ModernFurnitureFactory();
		Application modernFurnitureApp = new Application(modernFurnitureFactory);
		modernFurnitureApp.print();
		System.out.println();
		
		FurnitureFactory victorianFurnitureFactory = new VictorianFurnitureFactory();
		Application victorianFurnitureApp = new Application(victorianFurnitureFactory);
		victorianFurnitureApp.print();
		System.out.println();
		
		FurnitureFactory rusticFurnitureFactory = new RusticFurnitureFactory();
		Application rusticFurnitureApp = new Application(rusticFurnitureFactory);
		rusticFurnitureApp.print();
	}
}
