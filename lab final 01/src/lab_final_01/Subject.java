package lab_final_01;

public interface Subject {
	public abstract void registerObserver(Observer auctionBidder);
	public abstract void removeObserver(Observer auctionBidder);
	public abstract void notifyObservers();
}
