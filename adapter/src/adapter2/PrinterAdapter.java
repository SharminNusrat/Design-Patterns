package adapter2;

public class PrinterAdapter implements Printer{

	LegacyPrinter legacyPrinter = new LegacyPrinter();
	
	@Override
	public void print() {
		legacyPrinter.printDocument();
	}
}
