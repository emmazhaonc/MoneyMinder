package moneyminder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Igor Klekotnev on 18.09.15.
 */
public class TableWindow extends JFrame {
    String windowName;
    TableWindow(String name) {
        this.windowName = name;
    }
    public void show() {
        String[] headings =
                {"Заказ", "Ход выполнеения(%)", "Вырезка(кол-во детей)",
                "Сборка(кол-во разв.)","Стоимость вырезки", "Стоимость сборки", "Оплачено","Дата оплаты",
                "Заказчик", "Исполнитель", "Начало работы", "Дедлайт", "Софтлайн","Заметки"};
        Object[][] data = fillTable();
        JTable table = new JTable(data, headings);
        JFrame frame = new JFrame(windowName);
        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1240, 500);
        JMenu menu = new JMenu("Создать...");
        JMenuItem newOrder = new JMenuItem("Новый заказ");
        menu.add(newOrder);
        newOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderWindow orderWindow = new OrderWindow();
                orderWindow.show(frame);
            }
        });
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
    private Object[][] fillTable() {
        DBRequest rowsCount = new DBRequest("SELECT COUNT(*) AS rowcount FROM ORDERS");
        int count  = rowsCount.getRowsCount();
        Object[][] data = new Object[count][];
        for (int i = 0; i < count; i++) {
            DBRequest getOrderHeaderFromDB = new DBRequest("SELECT * FROM ORDERS WHERE ID='" + (i+1) + "'");
            data[i] = getOrderHeaderFromDB.getRowValues();
        }
        return data;
    }
}
