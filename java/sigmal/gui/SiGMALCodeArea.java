package sigmal.gui;

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
    
    //Will be used to highlight keywords
    public void textValueChanged(TextEvent e){
    }
}
