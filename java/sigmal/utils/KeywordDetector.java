package sigmal.utils;


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
                     word.equalsIgnoreCase("until") || word.equalsIgnoreCase("unless"));
    }
    
    public static boolean isValue(String word){
        word.trim();
        if(word.split(" ").length > 1) return false;
        else if(word.equalsIgnoreCase("true") || word.equalsIgnoreCase("false") ||
                word.equalsIgnoreCase("nothing") || word.equalsIgnoreCase("NA")) return true;
        else{
            //If it can be parsed as a number it's a value, otherwise it's not
            //There is no need to store the Integer because the test is pass/fail
            try{
                new Integer(word);
            }catch(NumberFormatException e){
                return false;
            }
            return true;
        }
    }
    
    public static boolean isKnownModifier(String word){
        word.trim();
        boolean found = false;
        for(String modifier : knownModifiers){
            if(word.equalsIgnoreCase(modifier)){
                found = true;
                break;
            }
        }
        return found;
    }
    
    public static Type getKeywordType(String word){
        if(isBlockStartKeyword(word)) return Type.blockStart;
        else if(isLogicKeyword(word)) return Type.logic;
        else if(isValue(word)) return Type.value;
        else if(isKnownModifier(word)) return Type.modifier;
        else return Type.none;
    }
    
    public static enum Type{
        blockStart,
        logic,
        value,
        modifier,
        object,
        envir,
        action,
        none
    }
}
