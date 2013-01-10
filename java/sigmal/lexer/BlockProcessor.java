package sigmal.lexer;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Stack;

public class BlockProcessor{
    public static void readFile(File f) throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        Stack<String> lines = new Stack();
        //ArrayList<Integer> blocks = new ArrayList();
        String line;
        // Read the file and turn it into am ArrayList of Strings with the comment lines removed.
        while((line = br.readLine())!=null){
            if(!line.startsWith("#")){
                lines.push(line.trim());
            }
        }
        
        Stack<String> block = new Stack();
        do{
            line = lines.pop();
            if(line==null){
                break;
            }else if (KeywordDetector.isBlockStartKeyword(line.split(" ")[0])){
                block.push(line);
                BlockProcessor.processBlock(block);
                block = new Stack();
            }else{
                block.push(line);
            }            
        }while(true);
    }
        
    private static void processBlock(Stack<String> block){
        if(block.get(0).startsWith("object")){
            String type;
            //If the block has a parameter list
            if(block.get(0).contains("[")){
                //The type name is the second word of whats before the brackets
                //Done this way to enable programmer to not put a space before the brackets
                type = block.get(0).substring(0, block.get(0).indexOf("[")).split(" ")[1];
                //Set the first line to whats in the brackets
                block.set(0, block.get(0).substring(block.get(0).indexOf("[")+1, block.get(0).indexOf("]")));
            }else{
                //The type name is the second word
                type = block.get(0).split(" ")[1];
                //Set the first line to "withoutParams"
                block.set(0, "withoutParams");
            }
            //Register the object type
            SiGMALObjectFactory.types.put(type, block);
        }
    }
}
