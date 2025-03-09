package templateMethod;

public abstract class LoanProcessor {
	public final void processLoan() {
		//common steps for all loan classes
		doBasicChecks();
		checkCreditScore();
		verifyIncome();
		
		//specialized steps - implemented by subclasses
		doLoanSpecificChecks();
		
		//common steps 
		calculateInterest();
		generateAgreement();
		disburseAmount();
	}
	
	public void doBasicChecks() {
		System.out.println("Performing basic checks...");
		System.out.println("Verifying customer identity...");
	}
	
	public void checkCreditScore() {
		 System.out.println("Checking credit score...");
	}
	
	public void verifyIncome() {
		System.out.println("Verifying income documents...");
	}
	
	protected abstract void doLoanSpecificChecks();
	
	public void calculateInterest() {
		System.out.println("Calculating interest rate...");
	}
	
	public void generateAgreement() {
		System.out.println("Generating loan agreement...");
	}
	
	 public void disburseAmount() {
	    System.out.println("Disbursing loan amount...");
	 }
}
