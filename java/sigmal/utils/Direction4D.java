package sigmal.utils;

public class Direction4D extends Direction{
     private double theta, phi, omicron;
     public Direction4D(double t, double p, double o){
         theta = t;
          phi = p;
          omicron = o;
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
     
    public void setTheta(int value){
        theta = value;
    }
    public void setPhi(int value){
        phi = value;
    }
    public void setOmicron(int value){
        omicron = value;
    }
	
    public int getDims(){
        return 4;
    }
}