package facade;

public class DVDPlayer {

	public void on() {
		System.out.println("DVD Player: Turning on.");
	}
	
	public void play(String movie) {
		System.out.println("DVD Player: Playing \"" + movie + "\".");
	}
	
	public void off() {
		System.out.println("DVD Player: Turning off.");
	}
}
