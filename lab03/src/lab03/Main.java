package lab03;

public class Main {

	public static void main(String[] args) {
		
		Department cseDepartment = new Department("CSE");
		Department cseDepartment2 = new Department("CSE");
		Department mathDepartment = new Department("Math");
		Department physicsDepartment = new Department("Physics");
		
		cseDepartment.requestPrinter();
		mathDepartment.requestPrinter();
		physicsDepartment.requestPrinter();
		
		System.out.println();
		
		
		cseDepartment.print("CSE211.pdf");
		mathDepartment.print("MATH301.pdf");
		physicsDepartment.print("FormulaSheet.pdf");
		cseDepartment.print("CSE302.pdf");
	}
}
