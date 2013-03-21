package sigmal.utils;

public class Direction2D extends Direction{
     private double theta;

     public Direction2D(double t){
         theta = t;
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
     
    public void setTheta(int value){
        theta = value;
    }
    public void setPhi(int value){}
    public void setOmicron(int value){}
	
    public int getDims(){
        return 2;
    }
}