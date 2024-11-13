package facade;

public class HomeTheaterFacade {

	private DVDPlayer dvdPlayer;
	private Projector projector;
	private Amplifier amplifier;
	private Lights lights;
	private Screen screen;
	
	public HomeTheaterFacade() {
		this.dvdPlayer = new DVDPlayer();
		this.projector = new Projector();
		this.amplifier = new Amplifier();
		this.lights = new Lights();
		this.screen = new Screen();
	}
	
	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie...");
		lights.dim(10);
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amplifier.on();
		amplifier.setSurroundSound();
		amplifier.setVolume(5);
		dvdPlayer.on();
		dvdPlayer.play(movie);
	}
	
	public void endMovie() {
		System.out.println("Shutting the theater down...");
		lights.on();
		screen.up();
		projector.off();
		amplifier.off();
		dvdPlayer.off();
	}
}
