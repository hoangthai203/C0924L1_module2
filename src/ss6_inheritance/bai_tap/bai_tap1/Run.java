package ss6_inheritance.bai_tap.bai_tap1;

public class Run {
    public static void main(String[] args) {
        Circle circle = new Circle(3.0, "red");
        Cylinder cylinder = new Cylinder(circle.getRadius(), circle.getColor(), 6.0);
        System.out.println(circle);
        System.out.println(cylinder);
    }
}
