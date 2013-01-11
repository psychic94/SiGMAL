package sigmal.lexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

//Used as a template for objects
public class SiGMALObject{
    //The name of the object type
    private final String type;
    //This instance's identifier
    private final String name;
    //The environment this object is in
    private final SiGMALEnvir envir;
    //The parameters that were used when this instance was created
    private final HashMap dimensions;
    //The parameters needed to create this object
    private final String params;
    //The code block from the original program file
    private final Stack<String> definition;
    //The list of sub parts this instance has
    private ArrayList<SiGMALObject> members;
    
    public SiGMALObject(String type, String name, Stack definition, ArrayList dimensions, SiGMALEnvir envir){
        this.type = type;
        this.name = name;
        this.envir = envir;
        this.dimensions = init(dimensions);
        this.params = (String)definition.remove(0);
        this.definition = definition;
    }
    
    private HashMap init(ArrayList dims){
        return null;
    }
    
    //Notify the environment to draw this instance
    public void render(){
        GraphicsHandler.renderObject(this, envir.getPanel());
        for(SiGMALObject member : members) GraphicsHandler.renderObject(member, envir.getPanel());
    }
    
    public void addMember(SiGMALObject member){
        members.add(member);
    }
}
