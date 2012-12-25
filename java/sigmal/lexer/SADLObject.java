package sigmal.lexer;

import java.util.ArrayList;

public class SADLObject{
    private final String type;
    private final String name;
    private final String params;
    private final ArrayList<String> definition;
    public SADLObject(String type, String name, ArrayList definition){
        this.type = type;
        this.name = name;
        this.params = (String)definition.remove(0);
        this.definition = definition;
    }
}
