package lab_final_01;

public class AuctionBidder implements Observer{
	private String name;

    public AuctionBidder(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName, double bidPrice) {
        System.out.println(name + " has been received notification: New bid on " + productName + " - Price: $" + bidPrice);
    }
}
