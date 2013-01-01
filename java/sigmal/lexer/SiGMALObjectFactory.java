package sigmal.lexer;

import java.util.HashMap;
import java.util.ArrayList;

public class SiGMALObjectFactory{
    public static HashMap<String, ArrayList<String>> types;
    public SiGMALObject create(String type, String name){
        return new SiGMALObject(type, name, types.get(type));
    }
}
