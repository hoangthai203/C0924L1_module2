package ss7_interface.resizeable;

import ss7_interface.code_gym.Circle;
import ss7_interface.code_gym.Rectangle;
import ss7_interface.code_gym.Shape;
import ss7_interface.code_gym.Square;

import java.util.Random;

public class Run {
    public static void main(String[] args) {
        // Tạo mảng các hình học
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.0);
        shapes[1] = new Rectangle(2.0, 4.0);
        shapes[2] = new Square(5.0);

        Random random = new Random();

        for (Shape shape : shapes) {
            System.out.println("Before resizing:");
            if (shape instanceof Circle) {
                System.out.println("Area: " + ((Circle) shape).getArea());
            } else if (shape instanceof Rectangle) {
                System.out.println("Area: " + ((Rectangle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println("Area: " + ((Square) shape).getArea());
            }

            double percent = 1 + random.nextInt(100);
            System.out.println("Resizing by " + percent + "%");

            if (shape instanceof IResizeable) {
                ((IResizeable) shape).resize(percent);
            }

            System.out.println("After resizing:");
            if (shape instanceof Circle) {
                System.out.println("New area: " + ((Circle) shape).getArea());
            } else if (shape instanceof Rectangle) {
                System.out.println("New area: " + ((Rectangle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println("New area: " + ((Square) shape).getArea());
            }
            System.out.println();
        }
    }
}
