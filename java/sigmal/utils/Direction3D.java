package sigmal.utils;

public class Direction3D extends Direction{
     private double theta, phi;
     public Direction3D(double t, double p){
         theta = t;
          phi = p;
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
     
    public void setTheta(int value){
        theta = value;
    }
    public void setPhi(int value){
        phi = value;
    }
    public void setOmicron(int value){}
	
    public int getDims(){
        return 3;
    }
}