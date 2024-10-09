package factoryMethod;

public class CircleFactory extends ShapeFactory{

	@Override
	public Shape createShape() {
		return new Circle();
	}
}
