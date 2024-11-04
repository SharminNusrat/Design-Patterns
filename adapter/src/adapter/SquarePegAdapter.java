package adapter;

public class SquarePegAdapter extends RoundPeg{

	SquarePeg peg;
	
	public SquarePegAdapter(SquarePeg peg) {
		this.peg = peg;
	}
	
	@Override
	public double getRadius() {
		double result;
		result = Math.sqrt(Math.pow(peg.getWidth()/2, 2)*2);
		return result;
	}
}
