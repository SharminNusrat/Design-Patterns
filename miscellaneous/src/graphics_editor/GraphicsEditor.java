package graphics_editor;

import java.util.ArrayList;
import java.util.List;

//---------- Factory Method Pattern ----------
interface Shape {
 void draw();
 void resize(int percentage);
 void move(int x, int y);
}

class Circle implements Shape {
 private int x, y, radius;
 private List<ShapeObserver> observers = new ArrayList<>();

 @Override
 public void draw() {
     System.out.println("Drawing Circle");
     notifyObservers();
 }

 @Override
 public void resize(int percentage) {
     radius *= (percentage / 100.0);
     notifyObservers();
 }

 @Override
 public void move(int x, int y) {
     this.x = x;
     this.y = y;
     notifyObservers();
 }

 private void notifyObservers() {
     observers.forEach(observer -> observer.update("Circle modified"));
 }
}

//class Rectangle implements Shape {
// // Similar implementation to Circle
// // ...
//}

abstract class ShapeFactory {
 abstract Shape createShape();
}

//---------- Composite Pattern ----------
class ShapeGroup implements Shape {
 private List<Shape> shapes = new ArrayList<>();

 public void addShape(Shape shape) {
     shapes.add(shape);
 }

 @Override
 public void draw() {
     shapes.forEach(Shape::draw);
 }

 @Override
 public void resize(int percentage) {
     shapes.forEach(shape -> shape.resize(percentage));
 }

 @Override
 public void move(int x, int y) {
     shapes.forEach(shape -> shape.move(x, y));
 }
}

//---------- Decorator Pattern ----------
abstract class ShapeDecorator implements Shape {
 protected Shape decoratedShape;

 public ShapeDecorator(Shape shape) {
     this.decoratedShape = shape;
 }

 @Override
 public void draw() {
     decoratedShape.draw();
 }
}

class BorderDecorator extends ShapeDecorator {
 public BorderDecorator(Shape shape) {
     super(shape);
 }

 @Override
 public void draw() {
     decoratedShape.draw();
     System.out.println("Adding border");
 }
}

class ColorFilter extends ShapeDecorator {
 private String color;

 public ColorFilter(Shape shape, String color) {
     super(shape);
     this.color = color;
 }

 @Override
 public void draw() {
     decoratedShape.draw();
     System.out.println("Applying " + color + " filter");
 }
}

//---------- Observer Pattern ----------
interface ShapeObserver {
 void update(String message);
}

class SaveSystem implements ShapeObserver {
 @Override
 public void update(String message) {
     System.out.println("Saving changes: " + message);
 }
}

class PreviewWindow implements ShapeObserver {
 @Override
 public void update(String message) {
     System.out.println("Updating preview: " + message);
 }
}

//---------- Strategy Pattern ----------
interface ResizeStrategy {
 void resize(Shape shape, int percentage);
}

class UniformResize implements ResizeStrategy {
 @Override
 public void resize(Shape shape, int percentage) {
     shape.resize(percentage);
 }
}

class ProportionalResize implements ResizeStrategy {
 @Override
 public void resize(Shape shape, int percentage) {
     // Maintain aspect ratio while resizing
     shape.resize(percentage);
 }
}

//Example usage
class GraphicsEditor {
 public static void main(String[] args) {
     // Create shapes and group
     Shape circle = new Circle();
//     Shape rectangle = new Rectangle();
     
     ShapeGroup group = new ShapeGroup();
     group.addShape(circle);
     group.addShape(rectangle);
     
     // Add decorators
     Shape decoratedCircle = new BorderDecorator(
         new ColorFilter(circle, "Blue")
     );
     
     // Add observers
     SaveSystem saveSystem = new SaveSystem();
     PreviewWindow previewWindow = new PreviewWindow();
     
     // Perform operations
     group.draw();
     decoratedCircle.draw();
     
     // Use resize strategy
     ResizeStrategy uniformResize = new UniformResize();
     uniformResize.resize(group, 150);
 }
}