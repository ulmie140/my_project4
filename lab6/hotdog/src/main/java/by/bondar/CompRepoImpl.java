package by.bondar;

import by.bondar.component.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для компонентов.
 */
public class CompRepoImpl implements ComponentRepo {
    private List<Component> components = new ArrayList<>();

    @Override
    public void add(Component component) {
        components.add(component);
        System.out.println("Добавлен компонент: " + component.getName());
    }

    @Override
    public void remove(Component component) {
        if (components.remove(component)) {
            System.out.println("Удален компонент: " + component.getName());
        } else {
            System.out.println("Компонент не найден: " + component.getName());
        }
    }

    @Override
    public void update(Component oldComponent, Component newComponent) {
        int index = components.indexOf(oldComponent);
        if (index != -1) {
            components.set(index, newComponent);
            System.out.println("Изменен компонент: " + oldComponent.getName() + " на " + newComponent.getName());
        } else {
            System.out.println("Компонент не найден: " + oldComponent.getName());
        }
    }

    @Override
    public List<Component> getAll() {
        return new ArrayList<>(components);
    }
}