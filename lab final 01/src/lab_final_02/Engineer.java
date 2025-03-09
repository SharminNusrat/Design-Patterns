package lab_final_02;

public class Engineer implements Employee{
	private double monthlySalary;
	
	public Engineer(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	@Override
	public void PayAmount() {
		System.out.println("Payable amount for manager: " + monthlySalary);
	}
}
