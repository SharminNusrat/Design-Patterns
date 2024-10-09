package lab01;

public class SmartphoneFactory extends DeviceFactory{

	@Override
	public Device createDevice() {
		return new Smartphone();
	}
}
