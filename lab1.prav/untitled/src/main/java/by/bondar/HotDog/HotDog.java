package by.bondar.HotDog;

/**
 * Абстрактный класс для всех видов хот-догов.
 */
public abstract class HotDog {
    protected String name; // Имя хот-дога
    protected double price; // Цена хот-дога

    public HotDog(String name, double price) {
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