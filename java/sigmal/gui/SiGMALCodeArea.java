package sigmal.gui;

import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class SiGMALCodeArea extends JTree implements TextListener{
    private CodeTreeNode codeTree;
    public SiGMALCodeArea(CodeTreeNode codeTree){
        super(codeTree);
        this.codeTree = codeTree;
        setOpaque(true);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        setMinimumSize(new Dimension(50, 50));
        ((DefaultTreeCellRenderer)getCellRenderer()).setLeafIcon(null);
        ((DefaultTreeCellRenderer)getCellRenderer()).setOpenIcon(null);
        ((DefaultTreeCellRenderer)getCellRenderer()).setClosedIcon(null);
    }
    
    //Used to bypass inability to call methods before calling the superclass contructor
    public static CodeTreeNode defaultCodeTree(){
        return new CodeTreeNode("<html><b>Unsaved Code</b></html>");
    }
    
    //Will be used to highlight keywords
    public void textValueChanged(TextEvent e){
    }
}
