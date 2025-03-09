package observer;

public class Main {
	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		
		MobileApp mobileApp = new MobileApp(weatherStation);
		EmergencyAlertSystem alertSystem = new EmergencyAlertSystem(weatherStation);
		NewsStation newsStation = new NewsStation(weatherStation);
		
		weatherStation.setWeatherMetrics(80.0f, 65.0f, 30.4f, 9.8f);
	}
}
