package observer;

public interface Observer {
	public abstract void update(float temp, float humidity, float pressure, float rainfall);
}
