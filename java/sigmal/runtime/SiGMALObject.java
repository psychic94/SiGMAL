package sigmal.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

//Used as a template for objects
public abstract class SiGMALObject{
    //The list of sub parts this instance has
    private ArrayList<SiGMALObject> members;
    
    //Notify the environment to draw this instance
    public abstract void render();
    
    public void addMember(SiGMALObject member){
        members.add(member);
    }
}
