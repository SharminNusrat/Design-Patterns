package lab01;

public class TabletFactory extends DeviceFactory{

	@Override
	public Device createDevice() {
		return new Tablet();
	}
}
