package sigmal.utils;

public class Point2D extends Point{
    //Cartesian coords
    private final double x, y;
    //Angular coords
    private transient double theta, r;

    public Point2D(double x, double y){
        this.x = x;
        this.y = y;
        this.theta = Math.atan2(y, x);
        this.r = Math.sqrt(x*x+y*y);
    }
    public Point2D(Direction2D dir, double rad){
         theta = dir.getTheta();
         r = rad;
         y = (theta*r)/Math.sqrt(1+theta*theta);
         x = Math.sqrt(r*r-y*y);
    }

    public Double getX(){
        return x;
    }
    public Double getY(){
        return y;
    }
    public Double getZ(){
        return null;
    }
    public Double getW(){
        return null;
    }

    public Double getTheta(){
        return theta;
    }
    public Double getPhi(){
        return null;
    }
    public Double getOmicron(){
        return null;
    }
    public Double getR(){
        return r;
    }

    public int getDims(){
        return 2;
    }

    //This instance:pt::return value:(0, 0)
    public Point2D relativeTo(Point2D pt){
        return new Point2D(x-pt.getX(), y-pt.getY());
    }

    //Translates the point relative to the perspective direction
    public Point2D relativeTo(Point2D pt, double yaw){
        Point2D pt2 = this.relativeTo(pt);
        yaw = pt2.getTheta() - yaw;
        return new Point2D(new Direction2D(yaw), pt2.getR());
    }

    //Returns the point in the epicenter of the Point cluster in the parameterr
    public static Point2D average(Point2D[] pts){
        double xsum=0, ysum=0;
        int ptnum=0;
        for(Point2D pt : pts){
            xsum += pt.getX();
            ysum += pt.getY();
            ptnum++;
        }
        return new Point2D(xsum / ptnum, ysum / ptnum);
    }
}
