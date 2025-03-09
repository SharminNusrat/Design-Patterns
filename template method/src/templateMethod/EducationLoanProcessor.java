package templateMethod;

public class EducationLoanProcessor extends LoanProcessor{
	@Override
    protected void doLoanSpecificChecks() {
        System.out.println("Verifying college admission letter...");
        System.out.println("Checking course fee structure...");
        System.out.println("Validating college recognition...");
    }
}
