package adapter3;

public class Main {

	public static void main(String[] args) {
		
		CartesianShape line = new LegacyLine();
        line.draw(5, 10);
        
        PolarPoint polarPoint = new PolarPoint(10, 45);
        CartesianShape adaptedPolarPoint = new PolarToCartesianAdapter(polarPoint);
        adaptedPolarPoint.draw(0, 0);
	}
}
