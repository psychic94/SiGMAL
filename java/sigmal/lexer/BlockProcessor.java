package sigmal.lexer;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class BlockProcessor{
    public void readFile(File f) throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> lines = new ArrayList();
        ArrayList<Integer> blocks = new ArrayList();
        String line;
        // Read the file and turn it into am ArrayList of Strings with the comment lines removed.
        while((line = br.readLine())!=null){
            if(!line.startsWith("#")){
                lines.add(line.trim());
            }
        }
        
        // Make a list of the lines that start each block
        for(int i=0; i<lines.size(); i++){
            line = lines.get(i).trim();
            if(line.startsWith("object") || line.startsWith("envir") || line.startsWith("action"))
                blocks.add(i);
        }
        lines.trimToSize();
        
        // Split the program lines into blocks and process them.
        ArrayList<String> block;
        for(int i=0; i<blocks.size()-1; i++){
            block = new ArrayList();
            for(int j=blocks.get(i); j<blocks.get(i+1); j++){
                if(!lines.get(j).trim().equals(""))
                    block.add(lines.get(j));
            }
            block.trimToSize();
            if(block.get(0).startsWith("object")){
                String type = block.get(0).substring(0, block.get(0).indexOf("[")).split(" ")[1];
                block.set(0, block.get(0).substring(block.get(0).indexOf("[")+1, block.get(0).indexOf("]")));
                SADLObjectFactory.types.put(type, block);
            }
        }
    }
}
