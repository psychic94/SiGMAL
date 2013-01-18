package sigmal.lexer;

import sigmal.utils.Point;

public class SiGMALCamera{
    private Point pos;
    private double theta;
    private double phi;

    public SiGMALCamera(){
        pos = new Point(0, 0, 0);
        theta = 0;
        phi = 0;
    }

    public Point getPos(){
        return pos;
    }

    public double getTheta(){
        return theta;
    }

    public double getPhi(){
        return phi;
    }
}
