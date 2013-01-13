package sigmal.gui;

import java.util.ArrayList;
import java.awt.Container;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class SiGMALDevKit{
    static SiGMALMenuBar menu;
    static JFrame frame;
    public static JTabbedPane tabs;
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
        
        //Adding components1
        tabs = new JTabbedPane();
        tabs.addTab("Unsaved Code", new SiGMALCodeArea());
        
        frame.add(tabs);
        
        //Layout setup
        layout = new SpringLayout();
        frame.setLayout(layout);
        //Menu
        layout.putConstraint(SpringLayout.NORTH, menu, 0, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, menu, 0, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.EAST, menu, 0, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.SOUTH, menu, 0, SpringLayout.NORTH, menu);
        //Code Area
        layout.putConstraint(SpringLayout.NORTH, tabs, 5, SpringLayout.SOUTH, menu);
        layout.putConstraint(SpringLayout.WEST, tabs, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.EAST, tabs, -5, SpringLayout.EAST, pane);
        layout.putConstraint(SpringLayout.SOUTH, tabs, -5, SpringLayout.SOUTH, pane);
        
        //Show window
        frame.setPreferredSize(new Dimension(500, 250));
        frame.pack();
        frame.setVisible(true);
    }  
}
