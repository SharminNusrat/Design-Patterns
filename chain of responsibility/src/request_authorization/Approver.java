package request_authorization;

public abstract class Approver {
	protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(Request request) {
        if (canApprove(request)) {
            approve(request);
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        } else {
            System.out.println("Request cannot be approved by anyone!");
        }
    }

    protected abstract boolean canApprove(Request request);

    protected abstract void approve(Request request);
}
