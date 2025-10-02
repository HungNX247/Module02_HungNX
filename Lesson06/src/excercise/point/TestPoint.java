package excercise.point;

public class TestPoint {
    public static void main(String[] args) {
        Point2D point2d = new Point2D();
        System.out.println(point2d);
        Point3D point3d = new Point3D();
        System.out.println(point3d);

        point2d = new Point2D(2.6f, 5.6f);
        System.out.println(point2d);
        point3d = new Point3D(2.7f, 3.2f, 4.7f);
        System.out.println(point3d);

        point2d.setXY(1, 2);
        System.out.println("Updated Point2D: " + point2d);
        point3d.setXYZ(1.2f, 2.6f, 3.9f);
        System.out.println("Updated Point3D: " + point3d);
    }
}
