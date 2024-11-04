package lab05;

public class LegacyPrinterClassAdapter extends LegacyPrinter implements Printer{

	@Override
	public void print() {
		oldPrintMethod("Class Adapter");
	}
}
