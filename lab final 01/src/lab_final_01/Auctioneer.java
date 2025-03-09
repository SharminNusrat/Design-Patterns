package lab_final_01;

import java.util.ArrayList;
import java.util.List;

public class Auctioneer implements Subject{
	private List<Observer> auctionBidders;
	private String productName;
	private double currentBidPrice;
	
	public Auctioneer(String productName) {
		this.productName = productName;
		auctionBidders = new ArrayList<>();
	}
	
	@Override
	public void registerObserver(Observer observer) {
		auctionBidders.add(observer);
	}
	
	@Override
	public void removeObserver(Observer observer) {
		int i = auctionBidders.indexOf(observer);
		if(i >= 0) {
			auctionBidders.remove(i);
		}
	}
	
	@Override
	public void notifyObservers() {
		for(Observer bidder: auctionBidders) {
			bidder.update(productName, currentBidPrice);
		}
	}
	
	public void setBidPrice(double bidPrice) {
		this.currentBidPrice = bidPrice;
		notifyObservers();
	}
}
