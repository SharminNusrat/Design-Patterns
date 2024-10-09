package lab01;

public class Tablet implements Device{

	private String model;

	@Override
	public void powerOn() {
		System.out.println("Tablet is powering on.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("Tablet is powering Off.");
	}
	
	@Override
	public String getDeviceDetails(String model) {
		return "Tablet - Model: " + model;
	}
}
