package sigmal.lexer;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import sigmal.runtime.*;

public class SiGMALObjectFactory{
    public static HashMap<String, Stack<String>> types;
    public SiGMALObject create(String type, String name, ArrayList params, SiGMALEnvir envir){
        return new SiGMALObject(type, name, types.get(type), params, envir);
    }
}
