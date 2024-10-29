package by.bondar;

import by.bondar.component.Bun;
import by.bondar.component.Cabbage;
import by.bondar.component.Carrot;
import by.bondar.component.Sausage;
import by.bondar.HotDog.Berlinka;
import by.bondar.HotDog.HunterDog;
import by.bondar.HotDog.MasterDog;

import java.text.DecimalFormat;

/**
 * Основной класс для демонстрации работы приложения.
 */
public class Main {
    public static void main(String[] args) {
        // Создание заказа
        Order order = new Order();

        order.addComponent(new Sausage());
        order.addComponent(new Carrot());
        order.finalizeOrder();

        order.addHotDog(new HunterDog());
        order.finalizeOrder();

        order.addHotDog(new MasterDog());
        order.finalizeOrder();

        order.addHotDog(new Berlinka());
        order.finalizeOrder();

        order.addComponent(new Cabbage());
        order.addComponent(new Bun());
        order.finalizeOrder();


        DecimalFormat df = new DecimalFormat("#.###");

        System.out.println("Общая сумма всех заказов: " + order.getTotalRevenue());
        System.out.println("Количество полных заказов (только хот-доги): " + order.getTotalHotDogOrders());
        System.out.println("Количество заказов компонентов: " + order.getTotalComponentOrders());
        System.out.println("Средняя стоимость всех заказов: " + df.format(order.getAverageOrderValue()));
    }
}
