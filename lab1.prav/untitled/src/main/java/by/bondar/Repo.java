package by.bondar;

import java.util.List;

public interface Repo<T> {
    void add(T t);
    void remove(T t);
    void update(T oldT, T newT);
    List<T> getAll();
}