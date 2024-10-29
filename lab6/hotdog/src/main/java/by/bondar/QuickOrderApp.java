package by.bondar;

import by.bondar.component.*;
import by.bondar.HotDog.*;
import by.bondar.component.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuickOrderApp extends JFrame {
    private JList<Component> componentList;
    private JList<HotDog> hotDogList;
    private DefaultListModel<Component> componentListModel;
    private DefaultListModel<HotDog> hotDogListModel;
    private JTextField componentNameField, componentPriceField, hotDogNameField, hotDogPriceField;

    public QuickOrderApp() {
        setTitle("Quick Order Application");
        setSize(900, 650); // Задаем размеры окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создаем модели списков
        componentListModel = new DefaultListModel<>();
        hotDogListModel = new DefaultListModel<>();

        // Создаем списки
        componentList = new JList<>(componentListModel);
        hotDogList = new JList<>(hotDogListModel);

        // Создаем панели для ввода компонентов
        JPanel componentPanel = new JPanel(new GridLayout(0, 1));
        componentNameField = new JTextField();
        componentPriceField = new JTextField();
        componentPanel.add(new JLabel("Название компонента:"));
        componentPanel.add(componentNameField);
        componentPanel.add(new JLabel("Цена компонента:"));
        componentPanel.add(componentPriceField);
        JButton addComponentButton = new JButton("Добавить компонент");
        JButton removeComponentButton = new JButton("Удалить компонент");
        JButton updateComponentButton = new JButton("Обновить компонент");
        componentPanel.add(addComponentButton);
        componentPanel.add(removeComponentButton);
        componentPanel.add(updateComponentButton);

        // Создаем панели для ввода хот-догов
        JPanel hotDogPanel = new JPanel(new GridLayout(0, 1));
        hotDogNameField = new JTextField();
        hotDogPriceField = new JTextField();
        hotDogPanel.add(new JLabel("Название хот-дога:"));
        hotDogPanel.add(hotDogNameField);
        hotDogPanel.add(new JLabel("Цена хот-дога:"));
        hotDogPanel.add(hotDogPriceField);
        JButton addHotDogButton = new JButton("Добавить хот-дог");
        JButton removeHotDogButton = new JButton("Удалить хот-дог");
        JButton updateHotDogButton = new JButton("Обновить хот-дог");
        hotDogPanel.add(addHotDogButton);
        hotDogPanel.add(removeHotDogButton);
        hotDogPanel.add(updateHotDogButton);

        // Добавляем списки и панели в главную форму
        add(new JScrollPane(componentList), BorderLayout.WEST);
        add(new JScrollPane(hotDogList), BorderLayout.EAST);
        add(componentPanel, BorderLayout.NORTH);
        add(hotDogPanel, BorderLayout.SOUTH);

        // Обработчики событий
        addComponentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addComponent();
            }
        });

        removeComponentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeComponent();
            }
        });

        updateComponentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateComponent();
            }
        });

        addHotDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addHotDog();
            }
        });

        removeHotDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeHotDog();
            }
        });

        updateHotDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHotDog();
            }
        });
    }

    private void addComponent() {
        String name = componentNameField.getText();
        double price = Double.parseDouble(componentPriceField.getText());
        Component component = new Component(name, price) {};
        componentListModel.addElement(component);
        componentNameField.setText("");
        componentPriceField.setText("");
    }

    private void removeComponent() {
        Component selected = componentList.getSelectedValue();
        if (selected != null) {
            componentListModel.removeElement(selected);
        }
    }

    private void updateComponent() {
        Component selected = componentList.getSelectedValue();
        if (selected != null) {
            String name = componentNameField.getText();
            double price = Double.parseDouble(componentPriceField.getText());
            Component updatedComponent = new Component(name, price) {};
            componentListModel.setElementAt(updatedComponent, componentList.getSelectedIndex());
        }
    }

    private void addHotDog() {
        String name = hotDogNameField.getText();
        double price = Double.parseDouble(hotDogPriceField.getText());
        HotDog hotDog = new HotDog(name, price) {};
        hotDogListModel.addElement(hotDog);
        hotDogNameField.setText("");
        hotDogPriceField.setText("");
    }

    private void removeHotDog() {
        HotDog selected = hotDogList.getSelectedValue();
        if (selected != null) {
            hotDogListModel.removeElement(selected);
        }
    }

    private void updateHotDog() {
        HotDog selected = hotDogList.getSelectedValue();
        if (selected != null) {
            String name = hotDogNameField.getText();
            double price = Double.parseDouble(hotDogPriceField.getText());
            HotDog updatedHotDog = new HotDog(name, price) {};
            hotDogListModel.setElementAt(updatedHotDog, hotDogList.getSelectedIndex());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuickOrderApp app = new QuickOrderApp();
            app.setVisible(true);
        });
    }
}