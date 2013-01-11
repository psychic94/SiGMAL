package sigmal.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class SiGMALDevKit{
    static SiGMALMenuBar menu;
    static JFrame frame;
    static ArrayList<CollapsibleCodeArea> codeAreas;
    static SpringLayout layout;
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
        CollapsibleCodeArea code = new CollapsibleCodeArea("Unsaved Code", new SiGMALCodeArea());
        
        frame.add(code);
        
        //Layout setup
        layout = new SpringLayout();
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
        frame.setPreferredSize(new Dimension(500, 250));
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void addCodeArea(CollapsibleCodeArea area){
        codeAreas.trimToSize();
        //The last area added
        CollapsibleCodeArea prevArea = codeAreas.get(codeAreas.size()-1);
        codeAreas.add(area);
        frame.add(area);
        
        Container pane = frame.getContentPane();
        layout.putConstraint(SpringLayout.NORTH, area, 5, SpringLayout.SOUTH, prevArea);
        layout.putConstraint(SpringLayout.WEST, area, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.EAST, area, -5, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.SOUTH, area, -5, SpringLayout.SOUTH, pane);
    }                
}
