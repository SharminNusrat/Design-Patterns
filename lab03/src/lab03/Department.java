package lab03;

public class Department {

	private String name;
	private Printer printer;
	
	public Department(String name) {
		this.name = name;
	}
	
	public void requestPrinter() {
		if(printer == null) {
			printer = Printer.getPrinter(name);
		}
	}
	
	public void print(String document) {
	     if (printer != null) {
	         printer.printDocument(document); 
	     } else {
	         System.out.println("No printer has been assigned for " + name + " department.");
	     }
	 }
}
