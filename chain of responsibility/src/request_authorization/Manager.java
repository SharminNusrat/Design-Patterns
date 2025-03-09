package request_authorization;

public class Manager extends Approver{
	@Override
    protected boolean canApprove(Request request) {
        return request.getAmount() <= 1000; // Manager can approve up to $1,000
    }

    @Override
    protected void approve(Request request) {
        System.out.println("Manager approved the request for $" + request.getAmount());
    }
}
