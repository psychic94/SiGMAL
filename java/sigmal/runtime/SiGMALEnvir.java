package sigmal.runtime;

import java.util.HashMap;
import java.util.Stack;
import sigmal.gui.SiGMALEnvirPanel;

public class SiGMALEnvir{
    //The name of the envornment
    private final String name;
    //Objects in this environment
    private HashMap<String, SiGMALObject> objects;
    //The panel displaying this environment
    private final SiGMALEnvirPanel panel;
    
    public SiGMALEnvir(String name, Stack definition, SiGMALEnvirPanel panel){
        this.name = name;
        this.panel = panel;
        this.create(definition);
    }
    
    private void create(Stack definition){
        
    }
    
    public SiGMALEnvirPanel getPanel(){
        return panel;
    }
}
