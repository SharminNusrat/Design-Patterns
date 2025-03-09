package decorator;

public class BasicCoffee implements Coffee{
	@Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getPrice() {
        return 70.0;
    }
}
