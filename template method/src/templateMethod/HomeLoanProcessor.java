package templateMethod;

public class HomeLoanProcessor extends LoanProcessor{
	@Override
    protected void doLoanSpecificChecks() {
        System.out.println("Performing property valuation...");
        System.out.println("Verifying property legal documents...");
        System.out.println("Checking property insurance...");
    }
}
