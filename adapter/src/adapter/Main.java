package adapter;

public class Main {

	public static void main(String[] args) {
		
		RoundHole hole = new RoundHole(10);
		
		RoundPeg rpeg = new RoundPeg(6);
		if(hole.fits(rpeg)) {
			System.out.println("Round peg r6 fits round hole r10");
		}
		
		SquarePeg smallSqPeg = new SquarePeg(5);
		SquarePeg largeSqPeg = new SquarePeg(20);
//		hole.fits(smallSqPeg);   won't compile.
		
		SquarePegAdapter smallPegAdapter = new SquarePegAdapter(smallSqPeg);
		SquarePegAdapter largePegAdapter = new SquarePegAdapter(largeSqPeg);
		
		if(hole.fits(smallPegAdapter)) {
			System.out.println("Square peg w5 fits round hole r10");
		}
		
		if(!hole.fits(largePegAdapter)) {
			System.out.println("Square peg w20 does not fit into round hole r10");
		}
	}
	
}
