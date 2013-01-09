package sigmal.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SiGMALDevKit{
    static SiGMALMenuBar menu;
    static JFrame frame;
    public static void main(String [] args){
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void createGUI(){
        //Window creation
        frame = new JFrame("SiGMAL Development Kit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        
        //Menu creation
        menu  = new SiGMALMenuBar();
        frame.setJMenuBar(menu);
        
        //Adding components
        SiGMALCodeArea code = new SiGMALCodeArea(SiGMALCodeArea.defaultCodeTree());
        frame.add(code);
        
        //Layout setup
        SpringLayout layout = new SpringLayout();
        frame.setLayout(layout);
        //Menu
        layout.putConstraint(SpringLayout.NORTH, menu, 0, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, menu, 0, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.EAST, menu, 0, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.SOUTH, menu, 0, SpringLayout.NORTH, menu);
        //Code Area
        layout.putConstraint(SpringLayout.NORTH, code, 5, SpringLayout.SOUTH, menu);
        layout.putConstraint(SpringLayout.WEST, code, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.EAST, code, -5, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.SOUTH, code, -5, SpringLayout.SOUTH, pane);
        
        //Show window
        //frame.setContentPane(frame);
        frame.pack();
        frame.setVisible(true);
    }
}
