package by.bondar;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс для взаимодействия с пользователем и запуска процесса сортировки.
 */
public class QuickSortApp {

    /**
     * Метод для запуска приложения.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);

        int[] array = getInputArray(scanner); // Получаем массив от пользователя
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, array.length - 1); // Сортируем массив
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
        scanner.close();
    }

    /**
     * Метод для получения массива от пользователя.
     */
    private int[] getInputArray(Scanner scanner) {
        System.out.println("Введите количество элементов массива:");

        int n = 0;
        while (true) {
            try {
                n = scanner.nextInt();
                // Проверяем, чтобы количество элементов было положительным
                if (n <= 0) {
                    System.out.println("Ошибка ввода. Количество элементов должно быть положительным.");
                    continue; // Возвращаемся к началу цикла
                }
                break; // Выход из цикла, если ввод корректен
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Пожалуйста, введите положительное целое число.");
                scanner.next(); // Удаляем некорректный ввод
            }
        }

        int[] array = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    array[i] = scanner.nextInt(); // Чтение элемента массива
                    break; // Выход из цикла, если ввод корректен
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода. Пожалуйста, введите целое число.");
                    scanner.next(); // Удаляем некорректный ввод
                }
            }
        }
        return array; // Возвращаем введенный массив
    }

    public static void main(String[] args) {
        new QuickSortApp().run(); // Запуск приложения
    }
}