package sigmal.utils;

public class Point4D extends Point{
    //Cartesian coords
    private final double x, y, z, w;
    //Angular coords
    private transient double theta, phi, omicron, r;

    public Point4D(double x, double y, double z, double w){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.r = Math.sqrt(x*x+y*y+z*z+w*w);
        this.theta = Math.atan2(y, x);
        this.phi = Math.atan2(z, Math.sqrt(x*x+y*y));
        this.omicron = Math.atan2(w, Math.sqrt(x*x+y*y+z*z));
    }
    public Point4D(Direction4D dir, double rad){
        theta = dir.getTheta();
        phi = dir.getPhi();
        omicron = dir.getOmicron();
        r = rad;
        w = (omicron*r)/Math.sqrt(1+omicron*omicron);
        double r3 = Math.sqrt(r*r-w*w);
        z = (phi*r3)/Math.sqrt(1+phi*phi);
        double r2 = Math.sqrt(r3*r3-z*z);
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
        return w;
    }

    public Double getTheta(){
        return theta;
    }
    public Double getPhi(){
        return phi;
    }
    public Double getOmicron(){
        return omicron;
    }
    public Double getR(){
        return r;
    }

    public int getDims(){
        return 4;
    }

    //This instance:pt::return value:(0, 0, 0)
    public Point4D relativeTo(Point4D pt){
        return new Point4D(x-pt.getX(), y-pt.getY(), z-pt.getZ(), w-pt.getW());
    }

    //Translates the point relative to the perspective direction
    public Point4D relativeTo(Point4D pt, double yaw, double pitch, double pitch4d){
        Point4D pt2 = this.relativeTo(pt);
        yaw = pt2.getTheta() - yaw;
        pitch = pt2.getPhi() - pitch;
        pitch4d = pt2.getOmicron() - pitch4d;
        return new Point4D(new Direction4D(yaw, pitch, pitch4d), pt2.getR());
    }

    //Returns the point in the epicenter of the Point cluster in the parameterr
    public static Point4D average(Point4D[] pts){
        double xsum=0, ysum=0, zsum=0, wsum=0;
        int ptnum=0;
        for(Point4D pt : pts){
            xsum += pt.getX();
            ysum += pt.getY();
            zsum += pt.getZ();
            wsum += pt.getW();
            ptnum++;
        }
        return new Point4D(xsum / ptnum, ysum / ptnum, zsum / ptnum, wsum / ptnum);
    }

    public Point2D projectTo2D(){
       Point3D pt = this.projectTo3D();
       return pt.projectTo2D();
    }
    
    public Point3D projectTo3D(){
        return new Point3D(Math.tan(theta), Math.tan(phi), Math.tan(omicron));
    }

    public Point4D projectTo4D(){
        return this;
    }
}
