package ss7_interface.colorable;

import ss7_interface.code_gym.Circle;
import ss7_interface.code_gym.Rectangle;
import ss7_interface.code_gym.Shape;
import ss7_interface.code_gym.Square;
import ss7_interface.resizeable.IResizeable;

import java.util.Random;

public class Run {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.0);
        shapes[1] = new Rectangle(2.0, 4.0);
        shapes[2] = new Square(5.0);

        Random random = new Random();

        for (Shape shape : shapes) {
            System.out.println("Shape details:");
            System.out.println(shape);

            if (shape instanceof Circle) {
                System.out.println("Area before resizing: " + ((Circle) shape).getArea());
            } else if (shape instanceof Rectangle) {
                System.out.println("Area before resizing: " + ((Rectangle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println("Area before resizing: " + ((Square) shape).getArea());
            }

            if (shape instanceof IResizeable) {
                double percent = 1 + random.nextInt(100);
                System.out.println("Resizing by: " + percent + "%");
                ((IResizeable) shape).resize(percent);
            }

            if (shape instanceof Circle) {
                System.out.println("Area after resizing: " + ((Circle) shape).getArea());
            } else if (shape instanceof Rectangle) {
                System.out.println("Area after resizing: " + ((Rectangle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println("Area after resizing: " + ((Square) shape).getArea());
            }

            if (shape instanceof IColorable) {
                ((IColorable) shape).howToColor();
            }

            System.out.println();
        }
    }
}
