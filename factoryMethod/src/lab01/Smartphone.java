package lab01;

public class Smartphone implements Device{
	
	private String model;

	@Override
	public void powerOn() {
		System.out.println("Smartphone is powering on.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("Smartphone is powering Off.");
	}
	
	@Override
	public String getDeviceDetails(String model) {
		return "Smartphone - Model: " + model;
	}
}
