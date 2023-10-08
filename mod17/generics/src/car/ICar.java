package car;

public interface ICar<T> {
    public String name(T entity);
    public String color(T entity);
    public String model(T entity);
    public Integer year(T value);
    public Integer horsePower(T value);
    public String toString();

}
