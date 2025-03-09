package observer;

public class MobileApp implements Observer{
//	private float temp;
//	private float humidity;
//	private float pressure;
//	private float rainfall;
	private Subject weatherStation;
	
	public MobileApp(Subject weatherStation) {
		this.weatherStation = weatherStation;
		weatherStation.addObserver(this);
	}
	
	@Override
	public void update(float temp, float humidity, float pressure, float rainfall) {
//		this.temp = temp;
//		this.humidity = humidity;
//		this.pressure = pressure;
//		this.rainfall = rainfall;
		System.out.println("Updates on Farmers' Mobile Apps: ");
		System.out.println("Temperature: " + temp);
		System.out.println("Humidity: " + humidity);
		System.out.println("Air Pressure: " + pressure);
		System.out.println("Rainfall: " + rainfall);
	}
}
