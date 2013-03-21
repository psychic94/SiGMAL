package sigmal.utils;

public class Ray{
    private Point point;
    private Direction direction;
    private int dims;
    public Ray(Point pt, Direction dir) throws DimMismatchException{
        if(pt.getDims()!=dir.getDims()) 
            throw new DimMismatchException("Tried to make ray with point and direction in different dimentions");
        point = pt;
        direction = dir;
        dims = point.getDims();
    }
    
    public Double getX(){
        return point.getX();
    }
    public Double getY(){
        return point.getY();
    }
    public Double getZ(){
        return point.getZ();
    }
    public Double getW(){
        return point.getW();
    }
    public Double getR(){
        return point.getR();
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
