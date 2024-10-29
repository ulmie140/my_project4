package by.bondar.component;

/**
 * Абстрактный класс для всех компонентов.
 */
public abstract class Component {
    protected String name;
    protected double price;

    public Component(String name, double price) {
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
