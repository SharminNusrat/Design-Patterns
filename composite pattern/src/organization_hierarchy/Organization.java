package organization_hierarchy;

import java.util.ArrayList;
import java.util.List;

// Component: Interface for both Employee and Department
interface OrganizationComponent {
    void showDetails();
    double getSalary();
}

// Leaf: Represents an Employee
class Employee implements OrganizationComponent {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name + ", Salary: $" + salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }
}

// Composite: Represents a Department
class Department implements OrganizationComponent {
    private String name;
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addComponent(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        for (OrganizationComponent component : components) {
            component.showDetails(); // Recursively show details of all components
        }
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (OrganizationComponent component : components) {
            totalSalary += component.getSalary(); // Recursively calculate the salary of all components
        }
        return totalSalary;
    }
}

// Client Code
public class Organization {
    public static void main(String[] args) {
        // Create employees
        OrganizationComponent emp1 = new Employee("John Doe", 50000);
        OrganizationComponent emp2 = new Employee("Jane Smith", 60000);
        OrganizationComponent emp3 = new Employee("Alice Johnson", 55000);

        // Create departments
        Department engineering = new Department("Engineering");
        Department hr = new Department("Human Resources");
        Department company = new Department("Company");

        // Add employees to departments
        engineering.addComponent(emp1);
        engineering.addComponent(emp2);
        hr.addComponent(emp3);

        // Add departments to the company
        company.addComponent(engineering);
        company.addComponent(hr);

        // Show details of the entire organization
        company.showDetails();

        // Calculate the total salary of the company
        System.out.println("Total salary of the company: $" + company.getSalary());
    }
}