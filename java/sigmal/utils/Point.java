package sigmal.utils;

public class Point{

    /**
     * Get a cartesian dimension.
     * @param order The order of the dimension to be returned
     */
    public Double getCartesianDim(int order)throws DimException{
        if(order==1) return x;
        else if(order==2) return y;
        else if(order<=0) throw new InvalidDimException();
        else throw new DimMismatchException("Point2D does not have a dimension of the "+order+"th order.");
    }

    /**
     * Get a cartesian dimension.
     * @param order The order of the dimension to be returned
     */
    public Double getAngularDim(int order)throws DimException{
        if(order==1) throw new InvalidDimException("There is no 1st order angular dimension.");
        else if(order==2) return theta;
        else if(order<=0) throw new InvalidDimException();
        else throw new DimMismatchException("Point2D does not have a dimension of the "+order+"th order.");
    }
}
