package sigmal.lexer;


public class KeywordDetector{
    public static String[] knownModifiers;
    
    public static boolean isBlockStartKeyword(String word){
        word.trim();
        if(word.split(" ").length > 1) return false;
        else return (word.equalsIgnoreCase("object") || word.equalsIgnoreCase("envir") ||
                     word.equalsIgnoreCase("action") || word.equalsIgnoreCase("when"));
    }
    
    public static boolean isLogicKeyword(String word){
        word.trim();
        if(word.split(" ").length > 1) return false;
        else return (word.equalsIgnoreCase("if") || word.equalsIgnoreCase("else") || 
                     word.equalsIgnoreCase("regardless") || word.equalsIgnoreCase("rgdls") || 
                     word.equalsIgnoreCase("repeat") || word.equalsIgnoreCase("while") || 
                     word.equalsIgnoreCase("until"));
    }
    
    public static boolean isKnownModifier(String word){
        word.trim();
        boolean found = false;
        for(String modifier : knownModifiers){
            if word.equalsIgnoreCase(modifier){
                found = true;
                break;
            }
        }
        return found;
    }
    
    public static Type getKeywordType(String word){
        
    }
    
    public static enum Type{
        blockStart;
        logic;
        value;
        modifier;
        object;
        envir;
        action;
    }
}
