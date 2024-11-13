package facade;

public class Lights {

	public void dim(int level) {
		System.out.println("Lights: Diming to " + level + "%.");
	}
	
	public void on() {
		System.out.println("Lights: Turning on.");
	}
}
