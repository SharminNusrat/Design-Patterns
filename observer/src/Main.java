import java.util.ArrayList;
import java.util.List;

interface Observer {
 void update(float temperature);
}

interface Subject {
 void addObserver(Observer observer);
 void removeObserver(Observer observer);
 void notifyObservers();
}

class WeatherStation implements Subject {
 private List<Observer> observers = new ArrayList<>();
 private float temperature;

 @Override
 public void addObserver(Observer observer) {
     observers.add(observer);
 }

 @Override
 public void removeObserver(Observer observer) {
     observers.remove(observer);
 }

 @Override
 public void notifyObservers() {
     for (Observer observer : observers) {
         observer.update(temperature);
     }
 }

 public void setTemperature(float temperature) {
     this.temperature = temperature;
     notifyObservers();
 }
}

class PhoneDisplay implements Observer {
 private String name;

 public PhoneDisplay(String name) {
     this.name = name;
 }

 @Override
 public void update(float temperature) {
     System.out.println(name + " received temperature update: " + temperature + "°C");
 }
}

class WebDisplay implements Observer {
 @Override
 public void update(float temperature) {
     System.out.println("Web display shows temperature update: " + temperature + "°C");
 }
}

public class Main {
 public static void main(String[] args) {
     WeatherStation weatherStation = new WeatherStation();

     Observer phoneDisplay1 = new PhoneDisplay("Phone Display 1");
     Observer phoneDisplay2 = new PhoneDisplay("Phone Display 2");
     Observer webDisplay = new WebDisplay();

     weatherStation.addObserver(phoneDisplay1);
     weatherStation.addObserver(phoneDisplay2);
     weatherStation.addObserver(webDisplay);

     System.out.println("Updating temperature to 25°C...");
     weatherStation.setTemperature(25);

     System.out.println("\nRemoving one phone display and updating temperature to 30°C...");
     weatherStation.removeObserver(phoneDisplay1);
     weatherStation.setTemperature(30);
 }
}
