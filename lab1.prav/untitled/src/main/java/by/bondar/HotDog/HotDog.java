package by.bondar.HotDog;

/**
 * Абстрактный класс для всех видов хот-догов.
 */
public abstract class HotDog {
    protected String name;
    protected double price;

    public HotDog(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
