package prototypeDesignPattern;

public class Demo {

	public static void main(String[] args) throws CloneNotSupportedException {

		BookShop bs = new BookShop();
		bs.setShopName("Novelty");
		bs.loadData();
		
		//bs.getBooks().remove(3);   // Because our copying is shallow copy, the 4th indexed book will be removed from both the bookshops
		
		System.out.println(bs);
		
//		BookShop bs1 = new BookShop();
//		bs1.setShopName("A1");
//		bs1.loadData();   // This will take time to fetch data from database
//		System.out.println(bs1);
		
		BookShop bs1 = (BookShop) bs.clone();
		bs.getBooks().remove(3);
		bs1.setShopName("A1");
		System.out.println(bs);
		System.out.println(bs1);
	}

}
