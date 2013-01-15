package sigmal.lexer;

import sigmal.gui.SiGMALEnvirPanel;
import java.awt.Point;

public class GraphicsHandler{
    public static void renderObject(SiGMALObject obj, SiGMALEnvirPanel panel){
    }
    
    public static Point projectTo2D(Point pt, SiGMALCamera cam){
        pt = toSpereical(pt, cam.getPos);
        //The line above stored theta as x, phi as y, and r as z
        double theta = pt.getX() - cam.getTheta();
        double phi = pt.getY() - cam.getPhi();
        double r = pt.getZ();
        if(r==0) return new Point(0, 0);
        pt = toCartesian(theta, phi, r);
        return new Point(pt.getX() / r, pt.getY() / r);
    }
    
    public static Point toSpherical(Point pt, Point center){
        return toSpherical(pt.getX()-center.getX(), pt.getY()-center.getY(), pt.getZ()-center.getZ());
    }
    
    public static Point toSpherical(double x, double y, double z){
        double r = Math.sqrt(x*x + y*y + z*z);
        double phi = Math.arctan(y/x);
        double theta = Math.arccos(z/r);
        return new Point(theta, phi, r);
    }
    
    public static Point toCartesian(double theta, double phi, double r){
        double x = r * Math.sin(theta) * Math.cos(phi);
        double y = r * Math.sin(theta) * Math.sin(phi);
        double z = r * Math.cos(theta));
        return new Point(x ,y, z);
    }
}
