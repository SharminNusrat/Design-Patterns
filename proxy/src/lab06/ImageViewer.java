package lab06;

public class ImageViewer {
	
	public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.png");
        Image image2 = new ProxyImage("photo2.png");

        System.out.println("User selects photo1:");
        image1.display();
        System.out.println();

        System.out.println("User selects photo2:");
        image2.display();
        System.out.println();

        System.out.println("User selects photo1 again:");
        image1.display();
    }
}
