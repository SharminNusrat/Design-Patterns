package request_authorization;

public class Director extends Approver{
	@Override
    protected boolean canApprove(Request request) {
        return request.getAmount() <= 10000; // Director can approve up to $10,000
    }

    @Override
    protected void approve(Request request) {
        System.out.println("Director approved the request for $" + request.getAmount());
    }
}
