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
    JMenu export;
    public SiGMALMenuBar(){
        super();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        tools = new JMenu("Tools");
        file.add(new JMenuItem("New", KeyEvent.VK_N));
        file.add(new JMenuItem("Open", KeyEvent.VK_O));
        file.add(new JMenuItem("Save", KeyEvent.VK_S));
        export = createExportTree();
        file.add(export);
        tools.add(new JMenuItem("Find", KeyEvent.VK_F));
        tools.add(new JMenuItem("Preferences"));
        add(file);
        add(edit);
        add(tools);
        setOpaque(true);
    }
    
    private JMenu createExportTree(){
        JMenu expimage = new JMenu("Image");
        expimage.add(new JMenuItem("JPEG"));
        expimage.add(new JMenuItem("GIF"));
        
        JMenu expvideo = new JMenu("Video");
        expvideo.add(new JMenuItem("AVI"));
        expvideo.add(new JMenuItem("FLV"));
        expvideo.add(new JMenuItem("MNG"));
        expvideo.add(new JMenuItem("MOV"));
        expvideo.add(new JMenuItem("WMV"));
        
        JMenu expmodel = new JMenu("Model");
        
        JMenu menu = new JMenu("Export");
        menu.add(expimage);
        menu.add(expvideo);
        //menu.add(expmodel);
        
        return menu;
    }
}
