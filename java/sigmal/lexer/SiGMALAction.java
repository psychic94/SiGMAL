package sigmal.lexer;

import java.util.HashMap;

public class SiGMALAction{
    private final String name;
    private HashMap<String, String> modifiers;

    public SiGMALAction(String name){
        this.name = name;
        modifiers = new HashMap();
    }

    /**Used in creating the list of modifiers
     * "Modifier" is the SiGMAL equivalent of "parameter".
     * @param type The name of what is being modified
     * @param value What the property is being modified to
     */
    public void modify(String type, String value){
        modifiers.put(type, value);
    }
}
