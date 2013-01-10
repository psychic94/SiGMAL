package sigmal.gui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;

public class CollapsibleCodeArea extends JPanel implements ActionListener{
    private JButton button;
    private JEditorPane code;
    private boolean collapsed;
    private SpringLayout layout;
    
    public CollapsibleCodeArea(){
        super();
    }
    
    public CollapsibleCodeArea(String header){
        this();
        button = new JButton(header);
        code = new JEditorPane();
        layout = new SpringLayout();
        this.setLayout(layout);
        this.add(button);
        this.add(code);
        layout.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, code, 0, SpringLayout.SOUTH, button);
        layout.putConstraint(SpringLayout.EAST, code, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.WEST, code, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, code, 0, SpringLayout.SOUTH, this);
        button.addActionListener(this);
        collapsed = false;
    }
    
    public CollapsibleCodeArea(String header, JEditorPane pane){
        this();
        button = new JButton(header);
        code = pane;
        layout = new SpringLayout();
        this.setLayout(layout);
        this.add(button);
        this.add(code);
        layout.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, code, 0, SpringLayout.SOUTH, button);
        layout.putConstraint(SpringLayout.EAST, code, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.WEST, code, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.SOUTH, code, 0, SpringLayout.SOUTH, this);
        button.addActionListener(this);
        collapsed = false;
    }
    
    public void actionPerformed(ActionEvent e){
        //We only care about actions on button
        if(!e.getSource().equals(button)) return;
        if(collapsed){
            collapsed = false;
            code.setSize(this.getWidth(), 250);
//             this.add(code);
//             code.setVisible(true);
//             layout.putConstraint(SpringLayout.NORTH, code, 0, SpringLayout.SOUTH, button);
//             layout.putConstraint(SpringLayout.EAST, code, 0, SpringLayout.EAST, this);
//             layout.putConstraint(SpringLayout.WEST, code, 0, SpringLayout.WEST, this);
//             layout.putConstraint(SpringLayout.SOUTH, code, 0, SpringLayout.SOUTH, this);
        }else{
            collapsed = true;
            code.setSize(this.getWidth(), 0);
//             layout.removeLayoutComponent(code);
//             this.remove(code);
//             code.setVisible(false);
        }
        repaint();
    }
}
