package sigmal.lexer;

import java.util.HashMap;
import java.util.Stack;

public class SiGMALObjectFactory{
    public static HashMap<String, Stack<String>> types;
    public SiGMALObject create(String type, String name){
        return new SiGMALObject(type, name, types.get(type));
    }
}
