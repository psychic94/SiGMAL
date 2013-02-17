package sigmal.utils;

public class Ray{
    private Point point;
    private Direction direction;
    private int dims;
    public Ray(Point pt, Direction dir){
        point = pt;
        direction = dir;
        dims = point.getDims();
    }
    
    public double getX(){
        return point.getX();
    }
    public double getY(){
        return point.getY();
    }
    public double getZ(){
        return point.getZ();
    }
    public double getW(){
        return point.getW();
    }
    public double getR(int dims){
        return point.getR(dims);
    }
    public Point getPoint(){
        return point;
    }
    
    public double getTheta(){
        return direction.getTheta();
    }
    public double getPhi(){
        return direction.getPhi();
    }
    public double getOmicron(){
        return direction.getOmicron();
    }
    public void setTheta(int value){
        direction.setTheta(value);
    }
    public void setPhi(int value){
        direction.setPhi(value);
    }
    public void setOmicron(int value){
        direction.setOmicron(value);
    }
    public Direction getDirection(){
        return direction;
    }
    
    public int getDims(){
        return dims;
    }
}
