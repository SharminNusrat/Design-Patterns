package lab_final_01;

public class Main {
	public static void main(String[] args) {
		Auctioneer auctioneer = new Auctioneer("product1");
		
		AuctionBidder auctionBidder1 = new AuctionBidder("John");
		AuctionBidder auctionBidder2 = new AuctionBidder("Lisa");
		
		auctioneer.registerObserver(auctionBidder1);
        auctioneer.registerObserver(auctionBidder2);
		
        auctioneer.setBidPrice(100.00);
		auctioneer.setBidPrice(200.00);
	}
}
