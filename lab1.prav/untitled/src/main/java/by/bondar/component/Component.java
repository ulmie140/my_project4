package by.bondar.component;

/**
 * Абстрактный класс для всех компонентов.
 */
public abstract class Component {
    protected String name; // Имя компонента
    protected double price; // Цена компонента

    public Component(String name, double price) {
        this.name = name; // Инициализация имени
        this.price = price; // Инициализация цены
    }

    public String getName() {
        return name; // Получение имени
    }

    public double getPrice() {
        return price; // Получение цены
    }
}