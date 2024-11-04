package lab05;

public class Main {

	public static void main(String[] args) {

		ModernPrinter modernPrinter = new ModernPrinter();
		modernPrinter.print();
		
		LegacyPrinterObjectAdapter objectAdapter = new LegacyPrinterObjectAdapter();
		objectAdapter.print();
		
		LegacyPrinterClassAdapter classAdapter = new LegacyPrinterClassAdapter();
		classAdapter.print();

	}

}
