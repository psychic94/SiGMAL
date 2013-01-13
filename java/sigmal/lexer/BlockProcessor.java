package sigmal.lexer;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import java.util.EmptyStackException;

public class BlockProcessor{
    public static Stack readFile(File f) throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        Stack<String> lines = new Stack();
        String line;
        // Read the file and turn it into a Stack of Strings
        while((line = br.readLine())!=null){
            lines.push(line.trim());
        }
        return flip(lines);
    }
    
    public void processCode(Stack<String> lines){
        Stack<String> block = new Stack();
        String line;
        do{
            try{
                line = lines.pop();
            }catch(EmptyStackException e){
                break;
            }
            if (KeywordDetector.isBlockStartKeyword(line.split(" ")[0])){
                block.push(line);
                processBlock(block);
                block = new Stack();
            }else{
                block.push(line);
            }            
        }while(true);
    }
        
    private static void processBlock(Stack<String> block){
        if(block.get(0).split(" ")[0].equals("object")){
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
        }else if(block.get(0).split(" ")[0].equals("envir")){
            
        }
    }
    
    public static Stack<String> flip(Stack<String> in){
        Stack<String> out = new Stack();
        do{
            String line;
            try{
                line = in.pop();
            }catch(EmptyStackException e){
                break;
            }
            out.push(line);
        }while(true);
        return out;
    }
}
