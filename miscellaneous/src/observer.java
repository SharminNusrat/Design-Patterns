
import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Bidder {
    void update(String product, double bidPrice);
}

// Concrete Observer (Bidder)
class AuctionBidder implements Bidder {
    private String name;

    public AuctionBidder(String name) {
        this.name = name;
    }

    @Override
    public void update(String product, double bidPrice) {
        System.out.println(name + " has been notified: New bid on " + product + " - Price: $" + bidPrice);
    }
}

// Subject (Observable)
class Auctioneer {
    private List<Bidder> bidders = new ArrayList<>();
    private String product;
    private double currentBid;

    public Auctioneer(String product) {
        this.product = product;
    }

    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    public void removeBidder(Bidder bidder) {
        bidders.remove(bidder);
    }

    public void newBid(double bidPrice) {
        this.currentBid = bidPrice;
        notifyBidders();
    }

    private void notifyBidders() {
        for (Bidder bidder : bidders) {
            bidder.update(product, currentBid);
        }
    }
}

// Main Class (Test Program)
public class AuctionSystem {
    public static void main(String[] args) {
        Auctioneer auctioneer = new Auctioneer("Antique Vase");

        // Creating bidders
        Bidder bidder1 = new AuctionBidder("Alice");
        Bidder bidder2 = new AuctionBidder("Bob");
        Bidder bidder3 = new AuctionBidder("Charlie");

        // Register bidders
        auctioneer.registerBidder(bidder1);
        auctioneer.registerBidder(bidder2);
        auctioneer.registerBidder(bidder3);

        // New bids
        auctioneer.newBid(100);
        auctioneer.newBid(150);
        auctioneer.newBid(200);
    }
}
