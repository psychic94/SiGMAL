package sigmal.lexer;

import java.util.HashMap;
import java.util.ArrayList;

public class SADLObjectFactory{
    public static HashMap<String, ArrayList<String>> types;
    public SADLObject create(String type, String name){
        return new SADLObject(type, name, types.get(type));
    }
}
