package abstractFactory;

public class MacCheckbox implements Checkbox{

	@Override
	public void check() {
		System.out.println("Checking Mac style Checkbox.");
	}
}
