package sigmal.lexer;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import java.util.EmptyStackException;

import sigmal.utils.KeywordDetector;

public class BlockProcessor{
    public static void readFile(File f) throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        Stack<String> lines = new Stack();
        String line;
        // Read the file and turn it into a Stack of Strings
        while((line = br.readLine())!=null){
            lines.push(line.trim());
        }
        //File is now upside down
        
        //Break file into blocks fromo the bottom up
        Stack<String> block = new Stack();
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
        if(block.peek().split(" ")[0].equals("object")){
            String type;
            //The type name is the second word of whats before the colon
            //Done this way to enable programmer to not put a space before the colon
            String line = block.pop();
            type = line.substring(0, line.indexOf(":")).split(" ")[1];
            SiGMALObjectFactory.types.put(type, flip(block));
            //Block is now upside down
        }else if(block.peek().split(" ")[0].equals("envir")){
            
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
