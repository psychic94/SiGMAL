package sigmal.runtime;

import sigmal.gui.SiGMALEnvirPanel;
import sigmal.utils.Point;

public class GraphicsHandler{
    public static void renderObject(SiGMALObject obj, SiGMALEnvirPanel panel){
    }
    
    public static Point projectTo2D(Point pt, SiGMALCamera cam){
        if(pt.getDims()==2){
            return point;
        }else if(pt.getDims()==3){
            pt = pt.relativeTo(cam.getPos(), cam.getYaw(), cam.getPitch());
            return new Point(Math.tan(pt.getTheta()), Math.tan(pt.getPhi()));
        }else if(pt.getDims()==4){
            pt = projectTo3D(pt, cam);
            return projectTo2D(pt, cam);
        }else{
            return null;
        }
    }
    
    public static Point projectTo3D(Point pt, SiGMALCamera cam){
        if(pt.getDims()==2){
            return new Point(pt.getX(), pt.getY(), 0);
        }else if(pt.getDims()==3){
            return pt;
        }else if(pt.getDims()==4){
            pt = pt.relativeTo(cam.getPos(), cam.getYaw(), cam.getPitch(), cam.getRoll());
            return new Point(Math.tan(pt.getTheta()), Math.tan(pt.getPhi()), Math.tan(pt.getOmicron());
        }else{
            return null;
        }
    }
}
