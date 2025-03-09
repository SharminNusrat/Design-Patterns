package lab_final_02;

public class Salesman implements Employee{
	private double monthlySalary;
	public double commission;
	
	public Salesman(double monthlySalary, double commission) {
		this.monthlySalary = monthlySalary;
		this.commission = commission;
	}
	
	@Override
	public void PayAmount() {
		double amount = monthlySalary + commission;
		System.out.println("Payable amount for salesman: " + amount);
	}
}
