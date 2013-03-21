package sigmal.utils;

public abstract class Direction{
    public abstract Double getTheta();
    public abstract Double getPhi();
    public abstract Double getOmicron();

    public abstract void setTheta(int value);
    public abstract void setPhi(int value);
    public abstract void setOmicron(int value);

    public abstract int getDims();
}
