package sigmal.utils;

public class Point{
    private final double x, y, z, w;
    //2D 3D or 4D
    private final double dims;
    public Point(double x, double y){
        this(x, y, 0, 0, 2);
    }
    public Point(double x, double y, double z){
        this(x, y, z, 0, 3);
    }
    public Point(double x, double y, double z, double w){
        this(x, y, z, w, 4);
    }
    public Point(double x, double y, double z, double w, double dims){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.dims = dims;
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
    public double getDims(){
        return dims;
    }
}
