package sigmal.gui;

import java.util.ArrayList;
import java.util.Stack;
import java.util.EmptyStackException;
import javax.swing.JEditorPane;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class SiGMALCodeArea extends JEditorPane implements TextListener{
    public SiGMALCodeArea(){
        super();
        setOpaque(true);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        setMinimumSize(new Dimension(50, 50));
    }
    
    public SiGMALCodeArea(ArrayList<String> lines){
        this();
        String code = "";
        for(String line : lines){
            code += line + "\n";
        }
        setText(code);
    }
    
    public SiGMALCodeArea(Stack<String> lines){
        this();
        String code = "";
        do{
            String line;
            try{
                line = lines.pop();
            }catch(EmptyStackException e){
                break;
            }
            code += line + "\n";
        }while(true);
        setText(code);
    }
    
    //Will be used to highlight keywords
    public void textValueChanged(TextEvent e){
    }
}
