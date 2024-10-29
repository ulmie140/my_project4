package by.bondar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class QuickSortSwingApp extends JFrame {
    private JTextField inputField;
    private JTextArea resultArea;
    private JButton sortButton;

    public QuickSortSwingApp() {
        setTitle("QuickSort");
        setSize(380, 250); // Уменьшенный размер окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1)); // Используем сетку для удобства

        // Ввод массива
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Введите массив (через запятую):"));
        inputField = new JTextField(15); // Уменьшенная ширина
        inputPanel.add(inputField);
        add(inputPanel);

        // Кнопка сортировки
        sortButton = new JButton("Сортировать");
        add(sortButton);

        // Область для отображения результатов
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        add(new JScrollPane(resultArea)); // Добавляем прокрутку

        // Обработчик события кнопки сортировки
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortArray();
            }
        });
    }

    private void sortArray() {
        String inputText = inputField.getText();
        try {
            // Преобразуем ввод в массив целых чисел
            String[] stringArray = inputText.split(",");
            int[] array = Arrays.stream(stringArray)
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // Сортируем массив
            QuickSort quickSort = new QuickSort();
            quickSort.quickSort(array, 0, array.length - 1);

            // Отображаем результат
            resultArea.setText("Отсортированный массив: " + Arrays.toString(array));
        } catch (NumberFormatException e) {
            resultArea.setText("Ошибка ввода. Введите целые числа, разделенные запятыми.");
        } catch (Exception e) {
            resultArea.setText("Ошибка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuickSortSwingApp app = new QuickSortSwingApp();
            app.setVisible(true);
        });
    }
}