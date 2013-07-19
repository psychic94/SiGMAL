package sigmal.utils;

/**
 * Thrown when a dimension is negative or zero
 */
public class InvalidDimException extends DimException{
    public InvalidDimException()
    {
        this("Tried to use a dimension less than one.");
    }
    
    public InvalidDimException(String message){
        super(message);
    }
}
