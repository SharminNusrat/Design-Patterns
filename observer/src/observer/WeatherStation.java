package observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
	private List<Observer> observers;
	private float temp;
	private float humidity;
	private float pressure;
	private float rainfall;
	
	public WeatherStation() {
		observers = new ArrayList<>();
	}
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	@Override
	public void removeObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if(i >= 0) {
			observers.remove(i);
		}
	}
	
	@Override
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update(temp, humidity, pressure, rainfall);
		}
	}
	
	public void weatherMetricsChanged() {
		notifyObservers();
	}
	
	public void setWeatherMetrics(float temp, float humidity, float pressure, float rainfall) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		this.rainfall = rainfall;
		weatherMetricsChanged();
	}
}
