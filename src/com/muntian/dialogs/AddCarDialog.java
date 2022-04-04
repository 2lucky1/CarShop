package com.muntian.dialogs;

import com.muntian.car.Car;
import com.muntian.car.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class AddCarDialog extends JDialog implements ActionListener {
    private Car car;

    private JTextField carNameTxt;
    private JComboBox<String> colorList;
    private JTextField carPriceTxt;

    private JButton btnAdd;
    private JButton btnCancel;

    public AddCarDialog(Frame parent) {
        super(parent, "Add Car", true);
        initUI();
    }

    private void initUI() {
        setLocation(new Point((getParent().getX() + getParent().getWidth() + 10), getY()));

        JLabel carNameLbl = new JLabel("Name", SwingConstants.CENTER);
        JLabel carColorLbl = new JLabel("Color", SwingConstants.CENTER);
        JLabel priceLbl = new JLabel("Price", SwingConstants.CENTER);

        carNameTxt = new JTextField();

        String[] colorStrings = {"red", "yellow", "black", "green", "blue"};
        colorList = new JComboBox<>(colorStrings);

        carPriceTxt = new JTextField("0");

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(this);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(this);

        setLayout(new GridLayout(4, 2));

        add(carNameLbl);
        add(carNameTxt);

        add(carColorLbl);
        add(colorList);

        add(priceLbl);
        add(carPriceTxt);

        add(btnAdd);
        add(btnCancel);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        btnAdd.setBackground(java.awt.Color.GREEN);
        btnAdd.setForeground(java.awt.Color.GRAY);
        if (source == btnAdd) {
            String colorStr = ((String)colorList.getSelectedItem());
            double price = Double.parseDouble(carPriceTxt.getText());
            car = new Car(carNameTxt.getText(), Color.valueOf(colorStr.toUpperCase()), new BigDecimal(price));
            System.out.println(car);

        } else {
            car = null;
        }

        dispose();
    }

    public Car run() {
        this.setVisible(true);
        return car;
    }
}
