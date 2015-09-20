package moneyminder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Igor Klekotnev on 18.09.15.
 */
public class OrderWindow {
    public void show(JFrame tableWindowFrame) {
        JFrame frame = new JFrame();
        frame.setSize(500, 400);
        JPanel topPanel = new JPanel(new GridLayout(2, 0));
        topPanel.setSize(500, 300);
        JPanel leftPanel = new JPanel(new GridLayout(5, 0));
        leftPanel.setSize(250, 100);
        leftPanel.setBackground(Color.GREEN);
        JPanel rightPanel =  new JPanel(new GridLayout(6, 0));
        rightPanel.setSize(250, 100);
        rightPanel.setBackground(Color.YELLOW);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setSize(500, 50);
        JPanel subTopPanelUp = new JPanel(new GridLayout(1, 0));
        JPanel subTopPanelDown = new JPanel(new GridLayout(1, 0));
        JPanel middlePanel = new JPanel(new GridLayout(1, 0));
        JPanel radioButtonPanel = new JPanel(new GridLayout(1, 0));
        radioButtonPanel.setBackground(Color.YELLOW);
        JButton cancelButton = new JButton("Отмена");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        middlePanel.add(leftPanel);
        middlePanel.add(rightPanel);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        JLabel orderNameLabel = new JLabel("Название заказа");
        JLabel childCountLabel = new JLabel("Кол-во детей");
        JTextField childCountTextField = new JTextField();
        subTopPanelUp.add(orderNameLabel);
        JLabel paymentPerChildLabel = new JLabel("Стоимость за одного ребёнка");
        JTextField paymentPerChildTextField = new JTextField();
        JTextField orderNameTextField = new JTextField(30);
        JCheckBox cutCheckBox = new JCheckBox("Вырезка");
        JCheckBox gatCheckBox = new JCheckBox("Сборка");

        JLabel albumTypeLabel = new JLabel("Количество разворотов альбома:");
        final ButtonGroup albumTypesButtonGroup = new ButtonGroup();
        JRadioButton eightPages = new JRadioButton("8", true);
        eightPages.setActionCommand(eightPages.getText());
        JRadioButton tenPages = new JRadioButton("10");
        tenPages.setActionCommand(tenPages.getText());
        albumTypesButtonGroup.add(eightPages);
        albumTypesButtonGroup.add(tenPages);
        JLabel paymentPerAlbumLabel = new JLabel("Стоимость альбома");
        JTextField paymentPerAlbumTextField = new JTextField();
        paymentPerAlbumTextField.setSize(200, 20);
        JButton okButton = new JButton("Готово");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBRequest putOrderHeaderInDB = new DBRequest(
                        "INSERT INTO ORDERS (HEADER, CUTTING, GATHERING, CUT_PRICE, GAT_PRICE) VALUES ('"
                                + orderNameTextField.getText() + "', "
                                + childCountValue(childCountTextField) + ", "
                                + radioButtonsValue(eightPages, tenPages, gatCheckBox) + ", "
                                + paymentPerChild (paymentPerChildTextField) + ", "
                                + paymentPerAlbum (paymentPerAlbumTextField)
                                + ")"
                );
                putOrderHeaderInDB.setValue();
                tableWindowFrame.dispose();
                TableWindow tableWindow = new TableWindow("Money Minder");
                tableWindow.show();
                frame.dispose();
            }
        });
        JLabel customerLabel = new JLabel("Заказчик");
        JTextField customerTextField = new JTextField(10);
        JLabel performerLabel = new JLabel("Исполнитель");
        JTextField performerTextField = new JTextField(10);

        leftPanel.add(cutCheckBox);
        leftPanel.add(childCountLabel);
        leftPanel.add(childCountTextField);
        leftPanel.add(paymentPerChildLabel);
        leftPanel.add(paymentPerChildTextField);

        rightPanel.add(gatCheckBox);
        rightPanel.add(albumTypeLabel);
        rightPanel.add(radioButtonPanel);
        radioButtonPanel.add(eightPages);
        radioButtonPanel.add(tenPages);
        rightPanel.add(paymentPerAlbumLabel);
        rightPanel.add(paymentPerAlbumTextField);

        bottomPanel.add(cancelButton);
        bottomPanel.add(okButton);
        subTopPanelUp.add(orderNameTextField);
        subTopPanelDown.add(customerLabel);
        subTopPanelDown.add(customerTextField);
        subTopPanelDown.add(performerLabel);
        subTopPanelDown.add(performerTextField);
        topPanel.add(subTopPanelUp, BorderLayout.NORTH);
        topPanel.add(subTopPanelDown, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    private int childCountValue (JTextField childCountTextField) {
        if (childCountTextField.getText().equals("")) {
            return 0;
        } else {
            return Integer.parseInt(childCountTextField.getText());
        }
    }
    private int radioButtonsValue(JRadioButton eight, JRadioButton ten, JCheckBox gatCheckBox) {
        int pagesNumber;
        if ((eight.getText().equals("8")) && (gatCheckBox.isSelected())) {
            pagesNumber = 8;
            return pagesNumber;
        } else if ((ten.getText().equals("10")) && (gatCheckBox.isSelected())) {
            pagesNumber = 10;
            return pagesNumber;
        } else {
            return 0;
        }
    }
    private float paymentPerChild (JTextField paymentPerChildTextField) {
        if (paymentPerChildTextField.getText().equals("")) {
            return 0;
        } else {
            return Float.parseFloat(paymentPerChildTextField.getText());
        }
    }
    private float paymentPerAlbum (JTextField paymentPerAlbumTextField) {
        if (paymentPerAlbumTextField.getText().equals("")) {
            return 0;
        } else {
            return Float.parseFloat(paymentPerAlbumTextField.getText());
        }
    }

}
