package request_authorization;

public class Main {
	public static void main(String[] args) {
        // Create approvers
        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        // Build the chain
        manager.setNextApprover(director);
        director.setNextApprover(ceo);

        // Test with different requests
        Request request1 = new Request("Buy office supplies", 500);
        Request request2 = new Request("Organize team-building event", 5000);
        Request request3 = new Request("Acquire new equipment", 20000);

        System.out.println("Processing Request 1:");
        manager.processRequest(request1);

        System.out.println("\nProcessing Request 2:");
        manager.processRequest(request2);

        System.out.println("\nProcessing Request 3:");
        manager.processRequest(request3);
    }
}
