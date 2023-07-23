package gr.aueb.cf.ch12.point;

/**
 * @author Ntirintis John
 */
public class PointXYZApp {
    public static void main(String[] args) {
        PointXYZ point3d = new PointXYZ();

        point3d.setX(1);
        point3d.setY(2);
        point3d.setZ(3);

        System.out.println(point3d);
    }
}
