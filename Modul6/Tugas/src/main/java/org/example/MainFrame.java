package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    CardLayout cardLayout;
    JPanel mainPanel;
    FormPanel formPanel;
    TablePanel tablePanel;

    public MainFrame() {
        setTitle("Laundry Pickup Scheduler");
        setSize(850, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        tablePanel = new TablePanel(this);
        formPanel = new FormPanel(this, tablePanel);

        mainPanel.add(tablePanel, "TABLE");
        mainPanel.add(formPanel, "FORM");

        add(mainPanel);
        cardLayout.show(mainPanel, "TABLE");

        tablePanel.loadFromCSV();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                tablePanel.saveToCSV();
            }
        });

        setVisible(true);
    }

    public void showForm() {
        cardLayout.show(mainPanel, "FORM");
    }

    public void showTable() {
        cardLayout.show(mainPanel, "TABLE");
    }
}
