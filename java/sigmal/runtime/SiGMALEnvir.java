package sigmal.runtime;

import java.util.HashMap;
import java.util.Stack;

public abstract class SiGMALEnvir{
    //Objects in this environment
    private HashMap<String, SiGMALObject> objects;
    //The cameras viewing this world
    private HashMap<String, SiGMALCamera> cameras;
    //The "active" camera used in the current view
    private String camera;
    
    //Associates an object to this environment
    public void addObject(String name, SiGMALObject obj){
        objects.put(name, obj);
    }
    
    //Removes association to the object and returns it
    public SiGMALObject removeObject(String name){
        return objects.remove(name);
    }
    
    //Deletes the object and its members
    public abstract void deleteObject();
    
    //Creates a view of the environment
    //If this is the first camera, switches to that camera
    public void addCamera(String name, SiGMALCamera cam){
        cameras.put(name, cam);
        if(cameras.size()==1) switchToCamera(name);
    }
    
    //Removes a view of the environment
    //If the active camera is removed, switches to the next camera
    public SiGMALCamera removeCamera(String name){
        SiGMALCamera cam = cameras.remove(name);
        if(camera.equals(name)){
            String[] cams = (String[]) cameras.keySet().toArray();
            switchToCamera(cams[0]);
        }
        return cam;
    }
    
    //Deletes a view of the environment
    //If the active camera is removed, switches to the next camera
    public abstract void deleteCamera(String name);
    
    //Switchers the active camera
    public void switchToCamera(String name){
        cameras.get(camera).setActivity(false);
        camera = name;
        cameras.get(camera).setActivity(true);
        render();
    }
    
    public abstract void render();
}
