package lab02;

public class Client {
	public static void main(String[] args) {
        // Modern Furniture
        FurnitureFactory modernFactory1 = ModernFurnitureFactory.getInstance();
        Chair modernChair1 = modernFactory1.createChair();
        Table modernTable1 = modernFactory1.createTable();
        Sofa modernSofa1 = modernFactory1.createSofa();
        
        FurnitureFactory modernFactory2 = ModernFurnitureFactory.getInstance();
        Chair modernChair2 = modernFactory2.createChair();
        Table modernTable2 = modernFactory2.createTable();
        Sofa modernSofa2 = modernFactory2.createSofa();

        System.out.println(modernChair1.getDescription());
        System.out.println(modernTable1.getDescription());
        System.out.println(modernSofa1.getDescription());
        
        System.out.println(modernChair2.getDescription());
        System.out.println(modernTable2.getDescription());
        System.out.println(modernSofa2.getDescription());

        // Victorian Furniture
        FurnitureFactory victorianFactory = VictorianFurnitureFactory.getInstance();
        Chair victorianChair = victorianFactory.createChair();
        Table victorianTable = victorianFactory.createTable();
        Sofa victorianSofa = victorianFactory.createSofa();

        System.out.println(victorianChair.getDescription());
        System.out.println(victorianTable.getDescription());
        System.out.println(victorianSofa.getDescription());
    }
}
