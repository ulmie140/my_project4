package by.bondar;

import by.bondar.component.Component;
import by.bondar.HotDog.HotDog;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для учета заказа.
 */
class Order {
    private List<HotDog> hotDogs = new ArrayList<>();
    private double hotDogTotalPrice = 0.0; // Общая стоимость только хот-догов
    private double componentTotalPrice = 0.0; // Общая стоимость компонентов
    private int totalHotDogOrders = 0; // Общее количество заказов с хот-догами
    private int totalComponentOrders = 0; // Общее количество заказов с компонентами
    private double totalRevenue = 0.0; // Общая сумма всех заказов

    public void addHotDog(HotDog hotDog) {
        hotDogs.add(hotDog);
        hotDogTotalPrice += hotDog.getPrice(); // Увеличиваем общую стоимость хот-догов
        System.out.println("Добавлен " + hotDog.getName() + " к заказу. Цена: " + hotDog.getPrice());
    }

    public void addComponent(Component component) {
        componentTotalPrice += component.getPrice(); // Увеличиваем общую стоимость компонентов
        totalComponentOrders++; // Увеличиваем счетчик заказов компонентов
        System.out.println("Продан " + component.getName() + " отдельно. Цена: " + component.getPrice());
    }

    public void finalizeOrder() {
        // Завершение заказа
        if (!hotDogs.isEmpty()) {
            totalHotDogOrders++;
            totalRevenue += hotDogTotalPrice + componentTotalPrice; // Добавляем цену заказа в общую сумму
            System.out.println("Заказ с хот-догами завершен. Общая стоимость: " + (hotDogTotalPrice + componentTotalPrice));
            hotDogTotalPrice = 0.0; // Сбрасываем цену текущего заказа
            componentTotalPrice = 0.0; // Сбрасываем цену компонентов
            hotDogs.clear(); // Очищаем список хот-догов
        } else if (componentTotalPrice > 0) {
            totalRevenue += componentTotalPrice; // Добавляем только стоимость компонентов
            System.out.println("Заказ с компонентами завершен. Общая стоимость: " + componentTotalPrice);
            componentTotalPrice = 0.0; // Сбрасываем цену компонентов
        } else {
            System.out.println("Нет хот-догов или компонентов для завершения заказа.");
        }
    }

    public int getTotalHotDogOrders() {
        return totalHotDogOrders; // Получение общего количества заказов с хот-догами
    }

    public int getTotalComponentOrders() {
        return totalComponentOrders; // Получение общего количества заказов с компонентами
    }

    public double getTotalRevenue() {
        return totalRevenue; // Получение общей суммы всех заказов
    }

    public double getAverageOrderValue() {
        // Получение средней стоимости всех заказов
        int totalOrders = totalHotDogOrders + totalComponentOrders;
        return totalOrders == 0 ? 0 : totalRevenue / totalOrders; // Возвращаем среднюю стоимость или 0
    }
}