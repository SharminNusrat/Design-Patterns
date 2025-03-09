package observer;

public class NewsStation implements Observer{
//	private float temp;
//	private float humidity;
//	private float pressure;
//	private float rainfall;
	private Subject weatherStation;
	
	public NewsStation(Subject weatherStation) {
		this.weatherStation = weatherStation;
		weatherStation.addObserver(this);
	}
	
	@Override
	public void update(float temp, float humidity, float pressure, float rainfall) {
//		this.temp = temp;
//		this.humidity = humidity;
//		this.pressure = pressure;
//		this.rainfall = rainfall;
		System.out.println("Updates for Local News Stations: ");
		System.out.println("Temperature: " + temp);
		System.out.println("Humidity: " + humidity);
		System.out.println("Air Pressure: " + pressure);
		System.out.println("Rainfall: " + rainfall);
	}
}
