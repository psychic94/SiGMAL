package sigmal.lexer;

import java.util.ArrayList;
import java.util.Stack;

//Used as a template for objects
public class SiGMALObject{
    //The name of the object type
    private final String type;
    //This instance's identifier
    private final String name;
    //The parameters used in creating this object
    private final String params;
    //The code block from the original program file
    private final Stack<String> definition;
    //The list of sub parts this instance has
    private ArrayList<SiGMALObject> members;
    
    public SiGMALObject(String type, String name, Stack definition){
        this.type = type;
        this.name = name;
        this.params = (String)definition.remove(0);
        this.definition = definition;
    }
    
    //Notify the environment to draw this instance
    public void render(){
        GraphicsHandler.renderObject(this);
    }
}
