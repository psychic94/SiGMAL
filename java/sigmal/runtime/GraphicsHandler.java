package sigmal.runtime;

import sigmal.gui.SiGMALEnvirPanel;
import sigmal.utils.Point;

public class GraphicsHandler{
    public static void renderObject(SiGMALObject obj, SiGMALEnvirPanel panel){
    }
    
    public static Point projectTo2D(Point pt, SiGMALCamera cam){
        pt = pt.relativeTo(cam.getPos(), cam.getYaw(), cam.getPitch());
        return new Point(Math.tan(pt.getTheta()), Math.tan(pt.getPhi()));
    }
}
