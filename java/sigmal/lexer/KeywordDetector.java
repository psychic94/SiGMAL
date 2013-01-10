package sigmal.lexer;


public class KeywordDetector{
    public static boolean isBlockStartKeyword(String word){
        word.trim();
        if(word.split(" ").length > 1) return false;
        else return (word.equalsIgnoreCase("object") || word.equalsIgnoreCase("envir") || word.equalsIgnoreCase("action") || word.equalsIgnoreCase("when"));
    }
}
