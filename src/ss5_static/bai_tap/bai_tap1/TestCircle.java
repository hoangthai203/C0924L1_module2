package ss5_static.bai_tap.bai_tap1;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.0);

        System.out.println("Circle 1 - Radius: " + circle1.getRadius());
        System.out.println("Circle 1 - Area: " + circle1.getArea());

        System.out.println("Circle 2 - Radius: " + circle2.getRadius());
        System.out.println("Circle 2 - Area: " + circle2.getArea());
    }
}

