package sigmal.gui;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.MenuShortcut;
import java.awt.event.KeyEvent;

public class SiGMALMenuBar extends JMenuBar{
    JMenu file;
    JMenu edit;
    JMenu tools;
    public SiGMALMenuBar(){
        super();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        tools = new JMenu("Tools");
        file.add(new JMenuItem("New", KeyEvent.VK_N));
        file.add(new JMenuItem("Open", KeyEvent.VK_O));
        file.add(new JMenuItem("Save", KeyEvent.VK_S));
        tools.add(new JMenuItem("Find", KeyEvent.VK_F));
        tools.add(new JMenuItem("Preferences"));
        add(file);
        add(edit);
        add(tools);
        setOpaque(true);
    }
}
