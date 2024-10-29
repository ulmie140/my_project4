package by.bondar;

import by.bondar.component.Component;
import by.bondar.HotDog.HotDog;
import by.bondar.component.Bun;
import by.bondar.component.Cabbage;
import by.bondar.component.Carrot;
import by.bondar.component.Sausage;
import by.bondar.HotDog.Berlinka;
import by.bondar.HotDog.HunterDog;
import by.bondar.HotDog.MasterDog;

public class Main {
    public static void main(String[] args) {
        // Создание репозитория для компонентов и хот-догов
        ComponentRepo componentRepo = new CompRepoImpl();
        HotDogRepo hotDogRepo = new HotDogRepoImpl();

        // Создание и добавление компонентов
        Bun bun = new Bun();
        Cabbage cabbage = new Cabbage();
        Carrot carrot = new Carrot();
        Sausage sausage = new Sausage();

        componentRepo.add(bun);
        componentRepo.add(cabbage);
        componentRepo.add(carrot);
        componentRepo.add(sausage);

        MasterDog masterDog = new MasterDog();
        HunterDog hunterDog = new HunterDog();
        Berlinka berlinka = new Berlinka();

        // Добавление хот-догов
        hotDogRepo.add(hunterDog);
        hotDogRepo.add(masterDog);
        hotDogRepo.add(berlinka);

        // Просмотр всех компонентов
        System.out.println("\nВсе компоненты:");
        for (Component component : componentRepo.getAll()) {
            System.out.println(component.getName() + " - " + component.getPrice());
        }

        // Просмотр всех хот-догов
        System.out.println("\nВсе хот-доги:");
        for (HotDog hotDog : hotDogRepo.getAll()) {
            System.out.println(hotDog.getName() + " - " + hotDog.getPrice());
        }

        // Удаление капусты
        System.out.println("\nУдаляем капусту:");
        componentRepo.remove(cabbage);

        // Обновление сосиски на лук
        System.out.println("\nОбновляем сосиску:");
        Component newOnion = new Component("Лук", 0.5) {
            @Override
            public String getName() {
                return "Лук";
            }

            @Override
            public double getPrice() {
                return 0.5;
            }
        };
        componentRepo.update(sausage, newOnion);

        // Обновление хот-дога
        System.out.println("\nОбновляем MasterDog:");
        HotDog Chicago = new MasterDog() {
            @Override
            public String getName() {
                return "Chicago";
            }
            @Override
            public double getPrice() {
                return 7.0; // Новая цена
            }
        };
        hotDogRepo.update(masterDog, Chicago);

        // Удаление хот-дога
        System.out.println("\nУдаляем HunterDog:");
        hotDogRepo.remove(hunterDog);

        // Просмотр всех оставшихся компонентов
        System.out.println("\nВсе оставшиеся компоненты:");
        for (Component component : componentRepo.getAll()) {
            System.out.println(component.getName() + " - " + component.getPrice());
        }

        // Просмотр всех оставшихся хот-догов
        System.out.println("\nВсе оставшиеся хот-доги:");
        for (HotDog hotDog : hotDogRepo.getAll()) {
            System.out.println(hotDog.getName() + " - " + hotDog.getPrice());
        }
    }
}