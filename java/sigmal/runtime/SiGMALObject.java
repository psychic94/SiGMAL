package sigmal.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import sigmal.utils.*;

//Used as a template for objects
public abstract class SiGMALObject{
    //The list of sub parts this instance has
    protected HashMap<String, SiGMALObject> members;
    protected ArrayList<Point> points;
    
    //Notify the environment to draw this instance
    public abstract void render();
    
    //Associates an object to this object
    public void addMember(String name, SiGMALObject member){
        members.put(name, member);
    }
    
    //Removes association to the member object and returns it
    public SiGMALObject removeMember(String name){
        return members.remove(name);
    }
    
    //Deletes the member object and its members
    public abstract void deleteMember(String name);
    
    //Rotates the object about a line
    //Axis>0:clockwise,axis<0:counterclockwise
    //Clockwise is defined by the perspective from the point specified in the ray looking in the diraction of the ray
    public abstract void rotate(Ray axis, double angle);
}
