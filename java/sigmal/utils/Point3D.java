package sigmal.utils;

public class Point3D extends Point{
    //Cartesian coords
    private final double x, y, z;
    //Angular coords
    private transient double theta, phi, r;

    public Point3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = Math.sqrt(x*x+y*y+z*z);
        this.theta = Math.atan2(y, x);
        this.phi = Math.atan2(z, Math.sqrt(r*r-z*z));
    }
    public Point3D(Direction3D dir, double rad){
        theta = dir.getTheta();
        phi = dir.getPhi();
        r = rad;
        z = (phi*r)/Math.sqrt(1+phi*phi);
        double r2 = Math.sqrt(r*r-z*z);
        y = (theta*r2)/Math.sqrt(1+theta*theta);
        x = Math.sqrt(r2*r2-y*y);
    }

    public Double getX(){
        return x;
    }
    public Double getY(){
        return y;
    }
    public Double getZ(){
        return z;
    }
    public Double getW(){
        return null;
    }

    public Double getTheta(){
        return theta;
    }
    public Double getPhi(){
        return phi;
    }
    public Double getOmicron(){
        return null;
    }
    public Double getR(){
        return r;
    }

    public int getDims(){
        return 3;
    }

    //This instance:pt::return value:(0, 0, 0)
    public Point3D relativeTo(Point3D pt){
        return new Point3D(x-pt.getX(), y-pt.getY(), z-pt.getZ());
    }

    //Translates the point relative to the perspective direction
    public Point3D relativeTo(Point3D pt, double yaw, double pitch){
        Point3D pt2 = this.relativeTo(pt);
        yaw = pt2.getTheta() - yaw;
        pitch = pt2.getPhi() - pitch;
        return new Point3D(new Direction3D(yaw, pitch), pt2.getR());
    }

    //Returns the point in the epicenter of the Point cluster in the parameterr
    public static Point3D average(Point3D[] pts){
        double xsum=0, ysum=0, zsum=0;
        int ptnum=0;
        for(Point3D pt : pts){
            xsum += pt.getX();
            ysum += pt.getY();
            zsum += pt.getZ();
            ptnum++;
        }
        return new Point3D(xsum / ptnum, ysum / ptnum, zsum / ptnum);
    }
}
