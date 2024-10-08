package abstractFactory;

public class Client {

	public static void main(String[] args) {
		
		GUIFactory windowsFactory = new WindowsFactory();
		Application windowsApp = new Application(windowsFactory);
		windowsApp.render();
		
		GUIFactory macFactory = new MacFactory();
		Application macApp = new Application(macFactory);
		macApp.render();
	}
}
