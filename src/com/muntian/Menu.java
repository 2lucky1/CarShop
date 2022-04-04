package com.muntian;

import com.muntian.car.Car;
import com.muntian.dialogs.AddCarDialog;

import javax.swing.*;
import java.awt.*;



public class Menu {

    private JButton addCarBtn;
    private JButton showAllCars;
    private JButton exitBtn;

    JTextArea textArea;

    private final CarShop carShop;

    private JFrame frame;

    public Menu(CarShop carShop) {
        this.carShop = carShop;
        initUI();
        addListeners();
    }

    private void initUI() {
        frame = new JFrame("Cars Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel generalPanel = new JPanel();

        JPanel menuPanel = new JPanel();
        JLabel menuLbl = new JLabel("Menu:", SwingConstants.CENTER);
        Font font = new Font(Font.SERIF, Font.BOLD, 16);
        menuLbl.setFont(font);
        menuLbl.setForeground(Color.RED);

        addCarBtn = new JButton("Add Car");
        showAllCars = new JButton("Show All Cars");
        exitBtn = new JButton("Exit");

        menuPanel.setLayout(new GridLayout(4, 1));
        menuPanel.add(menuLbl);
        menuPanel.add(addCarBtn);
        menuPanel.add(showAllCars);
        menuPanel.add(exitBtn);

        generalPanel.add(menuPanel);

        JPanel panelBottom = new JPanel();

        panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Entered Data");
        textArea = new JTextArea(10, 30);
        panelBottom.add(label);
        panelBottom.add(textArea);

        generalPanel.add(panelBottom);

        frame.getContentPane().add(BorderLayout.NORTH, generalPanel);
        frame.setVisible(true);
        frame.pack();

    }

    private void addListeners(){
        addCarBtn.addActionListener(e -> {
            AddCarDialog carDialog = new AddCarDialog(frame);
            Car addedCar = carDialog.run();
            if(addedCar != null){
                carShop.addCar(addedCar);
            }
        });

        showAllCars.addActionListener(e -> {
            StringBuilder sd = new StringBuilder();
            for (Car car : carShop.getCars()) {
                sd.append(car.toString()).append("\n");
            }
            textArea.setText(sd.toString());

        });

        exitBtn.addActionListener(e -> frame.dispose());
    }
}
