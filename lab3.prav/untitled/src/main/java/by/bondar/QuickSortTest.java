    package by.bondar;

    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.assertArrayEquals;

    /**
     * Класс для тестирования алгоритма быстрой сортировки.
     */
    public class QuickSortTest {
    
        private final QuickSort quickSort = new QuickSort();

        @Test
        public void testQuickSort() {
            int[] array = {3, 6, 8, 10, 1, 2, 1};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{1, 1, 2, 3, 6, 8, 10}, array);
        }

        @Test
        public void testEmptyArray() {
            int[] array = {};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{}, array);
        }

        @Test
        public void testSingleElementArray() {
            int[] array = {5};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{5}, array);
        }

        @Test
        public void testArrayWithDuplicates() {
            int[] array = {3, 1, 2, 1, 3};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{1, 1, 2, 3, 3}, array);
        }

        @Test
        public void testAlreadySortedArray() {
            int[] array = {1, 2, 3, 4, 5};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
        }

        @Test
        public void testReverseSortedArray() {
            int[] array = {5, 4, 3, 2, 1};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
        }

        @Test
        public void testNegativeNumbers() {
            int[] array = {-1, -3, -2, 0, 2};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{-3, -2, -1, 0, 2}, array);
        }

        @Test
        public void testAllSameElements() {
            int[] array = {2, 2, 2, 2, 2};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{2, 2, 2, 2, 2}, array);
        }

        @Test
        public void testLargeArray() {
            int[] array = {3, 6, 8, 10, 1, 2, 1, 9, 5, 7, 4, 0, 3, 2, 8, 6, 1};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 8, 8, 9, 10}, array);
        }

        @Test
        public void testLargeNumbers() {
            int[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 100000, -100000};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{Integer.MIN_VALUE, -100000, 0, 100000, Integer.MAX_VALUE}, array);
        }

        @Test
        public void testRandomOrderArray() {
            int[] array = {2, 5, 3, 1, 4};
            quickSort.quickSort(array, 0, array.length - 1);
            assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
        }
    }