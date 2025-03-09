package request_authorization;

public class CEO extends Approver{
	@Override
    protected boolean canApprove(Request request) {
        return true; // CEO can approve any amount
    }

    @Override
    protected void approve(Request request) {
        System.out.println("CEO approved the request for $" + request.getAmount());
    }
}
