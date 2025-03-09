package lab_final_02;

public class TestEmployee {
	public static void main(String[] args) {
		Employee manager = new Manager(20000, 2500);
		manager.PayAmount();
		
		Employee salesman = new Salesman(10000, 2500);
		salesman.PayAmount();
		
		Employee engineer = new Engineer(15000);
		engineer.PayAmount();
	}
}
