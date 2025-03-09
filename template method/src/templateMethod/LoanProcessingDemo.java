package templateMethod;

public class LoanProcessingDemo {
	public static void main(String[] args) {
		System.out.println("Processing Home Loan:");
        LoanProcessor homeLoan = new HomeLoanProcessor();
        homeLoan.processLoan();
        
        System.out.println("\nProcessing Car Loan:");
        LoanProcessor carLoan = new CarLoanProcessor();
        carLoan.processLoan();
        
        System.out.println("\nProcessing Education Loan:");
        LoanProcessor educationLoan = new EducationLoanProcessor();
        educationLoan.processLoan();
	}
}
