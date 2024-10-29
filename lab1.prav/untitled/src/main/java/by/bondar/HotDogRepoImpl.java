package by.bondar;

import by.bondar.HotDog.HotDog;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для хот-догов.
 */
public class HotDogRepoImpl implements HotDogRepo {
    private List<HotDog> hotDogs = new ArrayList<>();

    @Override
    public void add(HotDog hotDog) {
        hotDogs.add(hotDog);
        System.out.println("Добавлен хот-дог: " + hotDog.getName());
    }

    @Override
    public void remove(HotDog hotDog) {
        if (hotDogs.remove(hotDog)) {
            System.out.println("Удален хот-дог: " + hotDog.getName());
        } else {
            System.out.println("Хот-дог не найден: " + hotDog.getName());
        }
    }

    @Override
    public void update(HotDog oldHotDog, HotDog newHotDog) {
        int index = hotDogs.indexOf(oldHotDog);
        if (index != -1) {
            hotDogs.set(index, newHotDog);
            System.out.println("Изменен хот-дог: " + oldHotDog.getName() + " на " + newHotDog.getName());
        } else {
            System.out.println("Хот-дог не найден: " + oldHotDog.getName());
        }
    }

    @Override
    public List<HotDog> getAll() {
        return new ArrayList<>(hotDogs);
    }
}