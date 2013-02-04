package sigmal.utils;

public class Point{
    //Cartesian coordinates
    private final double x, y, z, w;
    //Spherical coordinates; theta is yaw, phi is pitch, omicron is roll(4D)
    private final double theta, phi, omicron;
    //2D 3D or 4D
    private final int dims;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
        this.z = 0;
        this.w = 0;
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
        this.theta = Math.atan2(y, x);
        this.phi = Math.atan2(z, getR(2));
        this.omicron = 0;
        this.dims = 3;
    }
    public Point(double x, double y, double z, double w){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.theta = Math.atan2(y, x);
        this.phi = Math.atan2(z, getR(2));
        this.omicron = Math.atan2(w, getR(3));
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
    public double getR(int dims){
        if(dims<=0) return 0;
        else if(dims==1) return x;
        else if(dims==2) return Math.sqrt(x*x+y*y);
        else if(dims==3) return Math.sqrt(x*x+y*y+z*z);
        else return Math.sqrt(x*x+y*y+z*z+w*w);
    }
    public int getDims(){
        return dims;
    }
    
    public Point relativeTo(Point pt){
        return new Point(x-pt.getX(), y-pt.getY(), z-pt.getZ(), w-pt.getW());
    }
    
    //This is for 2D use only
    public Point relativeTo(Point pt, double yaw){
        pt = this.relativeTo(pt);
        yaw = pt.getTheta() - yaw;
        double x2 = pt.getR(2) * Math.cos(yaw);
        double y2 = pt.getR(2) * Math.sin(yaw); 
        return new Point(x2, y2);
    }
    
    //This is for 3D use only
    public Point relativeTo(Point pt, double yaw, double pitch){
        pt = this.relativeTo(pt);
        yaw = pt.getTheta() - yaw;
        pitch = pt.getPhi() - pitch;
        double x2 = pt.getR(3) * Math.sin(pitch) * Math.cos(yaw);
        double y2 = pt.getR(3) * Math.sin(pitch) * Math.sin(yaw);
        double z2 = pt.getR(3) * Math.cos(pitch);        
        return new Point(x2, y2, z2);
    }
}
