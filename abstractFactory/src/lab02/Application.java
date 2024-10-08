package lab02;

public class Application {

	private Chair chair;
	private Table table;
	private Sofa sofa;
	
	public Application(FurnitureFactory factory) {
		this.chair = factory.createChair();
		this.table = factory.createTable();
		this.sofa = factory.createSofa();
	}
	
	public void print() {
		chair.sitOn();
		table.placeOn();
		sofa.lieOn();
	}
}
