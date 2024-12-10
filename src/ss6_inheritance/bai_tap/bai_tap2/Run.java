package ss6_inheritance.bai_tap.bai_tap2;

public class Run {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(1.5f, 2.5f);
        System.out.println("Point2D: " + point2D);

        Point3D point3D = new Point3D(3.5f, 4.5f, 5.5f);
        System.out.println("Point3D: " + point3D);

        point3D.setXYZ(6.5f, 7.5f, 8.5f);
        System.out.println("Updated Point3D: " + point3D);
    }
}
