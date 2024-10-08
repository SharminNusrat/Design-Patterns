package abstractFactory;

public class MacButton implements Button{

	@Override
	public void paint() {
		System.out.println("Rendering Mac style Button.");
	}
}
