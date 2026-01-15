package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class TablePanel extends JPanel {

    DefaultTableModel model;
    JTable table;
    MainFrame frame;
    private final String FILE_NAME = "laundry_data.csv";

    public TablePanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel header = new JLabel("Dashboard Laundry Pickup", JLabel.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 22));
        header.setBorder(BorderFactory.createEmptyBorder(15, 0, 40, 0));
        add(header, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{
                "Nama", "Alamat", "No HP", "Tanggal",
                "Layanan", "Berat (Kg)", "Total Bayar", "Status"
        }, 0);

        table = new JTable(model);
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setRowHeight(28);
        table.getTableHeader().setBackground(new Color(52, 73, 94));
        table.getTableHeader().setForeground(Color.WHITE);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton addBtn = new JButton("Tambah");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Hapus");

        style(addBtn, new Color(46, 204, 113));
        style(editBtn, new Color(241, 196, 15));
        style(deleteBtn, new Color(231, 76, 60));

        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        add(buttonPanel, BorderLayout.WEST);

        addBtn.addActionListener(e -> frame.showForm());
        editBtn.addActionListener(e -> editData());
        deleteBtn.addActionListener(e -> deleteData());
    }

    public void addRow(String[] data) {
        model.addRow(data);
    }

    public void updateRow(int row, String[] data) {
        for (int i = 0; i < data.length; i++) {
            model.setValueAt(data[i], row, i);
        }
    }

    private void editData() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu");
            return;
        }

        String[] data = new String[8];
        for (int i = 0; i < 8; i++) {
            data[i] = model.getValueAt(row, i).toString();
        }

        ((FormPanel) frame.mainPanel.getComponent(1)).setFormData(data, row);
        frame.showForm();
    }

    private void deleteData() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu");
            return;
        }
        model.removeRow(row);
    }

    public void saveToCSV() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (int i = 0; i < model.getColumnCount(); i++) {
                writer.write(model.getColumnName(i) + ",");
            }
            writer.write("\n");

            for (int r = 0; r < model.getRowCount(); r++) {
                for (int c = 0; c < model.getColumnCount(); c++) {
                    writer.write(model.getValueAt(r, c).toString() + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ignored) {
        }
    }

    public void loadFromCSV() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            model.setRowCount(0);
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                model.addRow(line.split(","));
            }
        } catch (IOException ignored) {
        }
    }

    private void style(JButton btn, Color c) {
        btn.setBackground(c);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setFocusPainted(false);
    }
}
