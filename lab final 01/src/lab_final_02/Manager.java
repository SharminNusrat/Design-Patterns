package lab_final_02;

public class Manager implements Employee{
	private double monthlySalary;
	public double bonus;
	
	public Manager(double monthlySalary, double bonus) {
		this.monthlySalary = monthlySalary;
		this.bonus = bonus;
	}
	
	@Override
	public void PayAmount() {
		double amount = monthlySalary + bonus;
		System.out.println("Payable amount for manager: " + amount);
	}
}
