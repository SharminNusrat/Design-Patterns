package lab06;

public class ProxyImage implements Image{

	private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
        	System.out.println("This is from realImage...");
            realImage = new RealImage(filename);
        }
        
        realImage.display();
    }
}
