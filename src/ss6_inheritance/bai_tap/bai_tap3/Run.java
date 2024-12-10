package ss6_inheritance.bai_tap.bai_tap3;

public class Run {
    public static void main(String[] args) {
        Point point = new Point(1.0f, 2.0f);
        System.out.println("Point: " + point);

        MovablePoint movablePoint = new MovablePoint(1.0f, 2.0f, 0.5f, 1.5f);
        System.out.println("MovablePoint: " + movablePoint);

        movablePoint.move();
        System.out.println("After move: " + movablePoint);
    }
}

