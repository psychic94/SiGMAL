package sigmal.utils;

public class Point{
    //Cartesian coordinates
    private final double x, y, z, w;
    //Spherical coordinates
    private final double theta, phi, omicron, r;
    //2D 3D or 4D
    private final int dims;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
        this.z = 0;
        this.w = 0;
        this.r = Math.sqrt(x*x + y*y);
        this.theta = Math.atan2(y, x);
        this.phi = 0;
        this.omicron = 0;
        this.dims = 2;
    }
    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 0;
        this.r = Math.sqrt(x*x + y*y + z*z);
        this.phi = Math.atan(y/x);
        this.theta = Math.acos(z/r);
        this.omicron = 0;
        this.dims = 3;
    }
    public Point(double x, double y, double z, double w){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.r = Math.sqrt(x*x + y*y + z*z + w*w);
        this.theta = 0;
        this.phi = 0;
        this.omicron = 0;
        this.dims = 4;
    }
    
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }
    public double getW(){
        return w;
    }
    public double getTheta(){
        return theta;
    }
    public double getPhi(){
        return phi;
    }
    public double getOmicron(){
        return omicron;
    }
    public double getR(){
        return r;
    }
    public int getDims(){
        return dims;
    }
    
    public Point relativeTo(Point pt){
        return new Point(x-pt.getX(), y-pt.getY(), z-pt.getZ(), w-pt.getW());
    }
}
