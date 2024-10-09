package lab01;

public class Main {

	public static void main(String[] args) {
		DeviceFactory factory;
		
		factory = new SmartphoneFactory();
		Device smartphone = factory.createDevice();
		smartphone.powerOn();
		System.out.println(smartphone.getDeviceDetails("Samsung Galaxy S21"));
		smartphone.powerOff();
		System.out.println();
		
		factory = new TabletFactory();
		Device tablet = factory.createDevice();
		tablet.powerOn();
		System.out.println(tablet.getDeviceDetails("iPad Pro"));
		tablet.powerOff();
		System.out.println();
		
		factory = new LaptopFactory();
		Device laptop = factory.createDevice();
		laptop.powerOn();
		System.out.println(laptop.getDeviceDetails("ASUS Zenbook 14"));
		laptop.powerOff();
	}
}
