package gr.aueb.cf.ch12.point;

/**
 * @author Ntirintis John
 */
public class PointXYZ {
    private int x;
    private int y;
    private int z;

    public PointXYZ() {}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "PointXYZ{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
