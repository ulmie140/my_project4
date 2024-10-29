package by.bondar;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortApp {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов массива:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
        scanner.close();
    }

    public static void main(String[] args) {
        new QuickSortApp().run();
    }
}
