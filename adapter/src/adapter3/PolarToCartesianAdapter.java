package adapter3;

public class PolarToCartesianAdapter implements CartesianShape{

	private PolarPoint polarPoint;
	
	public PolarToCartesianAdapter(PolarPoint polarPoint) {
		this.polarPoint = polarPoint;
	}
	
	@Override
	public void draw(int x, int y) {
		int cartesianX = (int) (polarPoint.getRadius() * Math.cos(Math.toRadians(polarPoint.getAngle())));
        int cartesianY = (int) (polarPoint.getRadius() * Math.sin(Math.toRadians(polarPoint.getAngle())));
        
        System.out.println("Drawing at converted Cartesian point (" + cartesianX + ", " + cartesianY + ")");
	}
}
