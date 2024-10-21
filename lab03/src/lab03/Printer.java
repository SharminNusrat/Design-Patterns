package lab03;

import java.util.HashMap;
import java.util.Map;

public class Printer {

	private static Map<String, Printer> printerRegistry = new HashMap<>();
	public String deptName;
	
	private Printer(String deptName) {
		this.deptName = deptName;
		System.out.println("Printer has been created for department: " + deptName);
	}
	
	public static Printer getPrinter(String deptName) {
		Printer printer = printerRegistry.get(deptName);
		
		if (printer == null) {
            printer = new Printer(deptName);
            printerRegistry.put(deptName, printer);
        }
		
		return printer;
	}
	
	public void printDocument(String document) {
		System.out.println("Printing document " + document + " for " + deptName + " department");
	}
}
