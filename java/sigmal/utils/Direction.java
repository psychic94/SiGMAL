package sigmal.utils;

public class Direction{
    private double theta, phi, omicron;
    private final int dims;

    public Direction(double theta){
        this.theta = theta;
        this.dims = 2;
    }
    public Direction(double theta, double phi){
        this.theta = theta;
        this.phi = phi;
        this.dims = 3;
    }
    public Direction(double theta, double phi, double omicron){
        this.theta = theta;
        this.phi = phi;
        this.omicron = omicron;
        this.dims = 4;
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
    public int getDims(){
        return dims;
    }
    
    public double setTheta(int value){
        theta = value;
    }
    public double setPhi(int value){
        phi = value;
    }
    public double getOmicron(int value){
        omicron = value;
    }
}
