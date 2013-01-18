package sigmal.gui;

import java.util.Stack;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.MenuShortcut;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import sigmal.lexer.BlockProcessor;

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
        JMenuItem fileopen = new JMenuItem("Open", KeyEvent.VK_O);
        fileopen.addActionListener(new FileOpener());
        file.add(fileopen);
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
    
    private class FileOpener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JFileChooser fc = new JFileChooser();
            fc.setMultiSelectionEnabled(true);
            int returnVal = fc.showOpenDialog(null);
            if (returnVal != JFileChooser.APPROVE_OPTION) return;
            File[] fileList = fc.getSelectedFiles();
            for(File file : fileList){
                Stack text = new Stack();
                try{
                    text = BlockProcessor.readFile(file);
                }catch(Exception exception){
                    String message = "An error occured while processing " + file.getName() + ".\n";
                    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
                }
                if(text.size()!=0)
                    SiGMALDevKit.tabs.addTab("Code from " + file.getName(), new JScrollPane(new SiGMALCodeArea(text)));
            }
        }
    }
}