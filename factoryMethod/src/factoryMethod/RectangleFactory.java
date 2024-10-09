package factoryMethod;

public class RectangleFactory extends ShapeFactory{

	@Override
	public Shape createShape() {
		return new Rectangle();
	}
}