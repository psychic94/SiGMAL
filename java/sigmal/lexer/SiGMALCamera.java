package sigmal.lexer;

import sigmal.utils.Point;

public class SiGMALCamera{
    private Point pos;
    private double yaw;
    private double pitch;

    public SiGMALCamera(){
        pos = new Point(0, 0, 0);
        yaw = 0;
        pitch = 0;
    }

    public Point getPos(){
        return pos;
    }

    public double getYaw(){
        return yaw;
    }

    public double getPitch(){
        return pitch;
    }
}
