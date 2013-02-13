package sigmal.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import sigmal.utils.*;

//Used as a template for objects
public abstract class SiGMALObject{
    //The list of sub parts this instance has
    protected HashMap<SiGMALObject> members;
    protected ArrayList<Point> points;
    
    //Notify the environment to draw this instance
    public abstract void render();
    
    //Associates an object to this objce
    public void addMember(String name, SiGMALObject member){
        members.put(name, member);
    }
    
    //Removes association to the member object and associates the ex-member with the environment
    public abstract void removeMember(String name);
    
    //Deletes the member object and its members
    public abstract void deleteMember(String name);
    
    //Rotates the object about a line
    //Axis>0:clockwise,axis<0:counterclockwise
    //Clockwise is defined by the perspective from the point specified in the ray looking in the diraction of the ray
    public abstract rotate(Ray axis, double angle);
}
