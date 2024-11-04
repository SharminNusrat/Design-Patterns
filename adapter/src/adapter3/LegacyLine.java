package adapter3;

public class LegacyLine implements CartesianShape{

	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing a line to cartesian point (" + x + "," + y + ")");
	}
}
