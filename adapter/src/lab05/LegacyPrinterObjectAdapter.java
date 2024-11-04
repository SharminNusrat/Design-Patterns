package lab05;

public class LegacyPrinterObjectAdapter implements Printer{

	LegacyPrinter legacyPrinter = new LegacyPrinter();
	
	@Override
	public void print() {
		legacyPrinter.oldPrintMethod("Object Adapter");
	}
}
