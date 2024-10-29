package by.bondar;

/**
 * Класс для реализации алгоритма быстрой сортировки.
 */
public class QuickSort {

    /**
     * Метод для сортировки массива.
     */
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high); // Разделение массива
            quickSort(array, low, pivotIndex - 1); // Сортировка левой части
            quickSort(array, pivotIndex + 1, high); // Сортировка правой части
        }
    }

    /**
     * Метод для разделения массива на две части.
     */
    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Опорный элемент
        int i = low - 1; // Индекс меньшего элемента

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) { // Сравнение текущего элемента с опорным
                i++; // Увеличиваем индекс меньшего элемента
                swap(array, i, j); // Обмен элементов
            }
        }
        swap(array, i + 1, high); // Перемещение опорного элемента в правильное место
        return i + 1; // Возврат индекса опорного элемента
    }

    /**
     * Метод для обмена элементов массива.
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}