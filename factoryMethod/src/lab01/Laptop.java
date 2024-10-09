package lab01;

public class Laptop implements Device{

	private String model;

	@Override
	public void powerOn() {
		System.out.println("Laptop is powering on.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("Laptop is powering Off.");
	}
	
	@Override
	public String getDeviceDetails(String model) {
		return "Laptop - Model: " + model;
	}
}
