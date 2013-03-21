package sigmal.lexer;

import java.util.HashMap;

public class ActionDefinition{
    //The name of the action
    private final String name;
    //The modifiers that can be used with this action
    //The key is the name of the modifier
    //The value is the default value or null if no default is set
    private HashMap<String, String> modifiers;
    //What this action means, ie the code it runs
    private String[] meaning;

    public ActionDefinition(String name){
        this.name = name;
    }

    public void addModifier(String type){
        addModifier(type, null);
    }
    public void addModifier(String type, String default){
        modifiers.put(type, default);
    }

    public void setMeaning(String[] code){
        meaining = code;
    }
    public String[] getMeaning(){
        return meaning;
    }
}
