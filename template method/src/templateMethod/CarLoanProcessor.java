package templateMethod;

public class CarLoanProcessor extends LoanProcessor{
	 @Override
	 protected void doLoanSpecificChecks() {
	     System.out.println("Inspecting vehicle condition...");
	     System.out.println("Verifying vehicle insurance...");
	     System.out.println("Checking vehicle registration...");
	 }
}
