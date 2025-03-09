package lab02;

public class RusticFurnitureFactory implements FurnitureFactory{
private static volatile RusticFurnitureFactory instance;
	
	private RusticFurnitureFactory() {}
	
	public static RusticFurnitureFactory getInstance() {
		if(instance == null) {
			synchronized(RusticFurnitureFactory.class){
				if(instance == null) {
					instance = new RusticFurnitureFactory();
				}
			}
		}
		
		return instance;
	}
	
	@Override
	public Chair createChair() {
		return new RusticChair();
	}
	
	@Override
	public Table createTable() {
		return new RusticTable();
	}
	
	@Override
	public Sofa createSofa() {
		return new RusticSofa();
	}
}
