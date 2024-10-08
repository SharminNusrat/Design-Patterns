package abstractFactory;

public class WinCheckbox implements Checkbox{

	@Override
	public void check() {
		System.out.println("Checking Windows style Checkbox.");
	}
}
