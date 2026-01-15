package org.example;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {

    JTextField nameField, addressField, phoneField, dateField, weightField;
    JComboBox<String> serviceBox, statusBox;
    TablePanel tablePanel;
    MainFrame frame;
    int selectedRow = -1;

    public FormPanel(MainFrame frame, TablePanel tablePanel) {
        this.frame = frame;
        this.tablePanel = tablePanel;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Form Pickup & Pembayaran Laundry", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nameField = createField();
        addressField = createField();
        phoneField = createField();
        dateField = createField();
        weightField = createField();

        serviceBox = new JComboBox<>(new String[]{"Cuci Kering", "Cuci Setrika", "Express"});
        statusBox = new JComboBox<>(new String[]{"Belum Dibayar", "Sudah Dibayar"});

        int y = 0;
        addRow(form, gbc, "Nama", nameField, y++);
        addRow(form, gbc, "Alamat", addressField, y++);
        addRow(form, gbc, "No HP", phoneField, y++);
        addRow(form, gbc, "Tanggal Pickup", dateField, y++);
        addRow(form, gbc, "Layanan", serviceBox, y++);
        addRow(form, gbc, "Berat (Kg)", weightField, y++);
        addRow(form, gbc, "Status Pembayaran", statusBox, y++);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        JButton saveBtn = new JButton("Simpan");
        JButton backBtn = new JButton("Kembali");

        style(saveBtn, new Color(52, 152, 219));
        style(backBtn, new Color(149, 165, 166));

        buttonPanel.add(saveBtn);
        buttonPanel.add(backBtn);

        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 2;
        form.add(buttonPanel, gbc);

        add(form, BorderLayout.CENTER);

        saveBtn.addActionListener(e -> saveData());
        backBtn.addActionListener(e -> frame.showTable());
    }

    private JTextField createField() {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(200, 30));
        return field;
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, String label, JComponent comp, int y) {
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        panel.add(comp, gbc);
    }

    private void saveData() {
        if (nameField.getText().isEmpty() ||
                addressField.getText().isEmpty() ||
                phoneField.getText().isEmpty() ||
                dateField.getText().isEmpty() ||
                weightField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua input wajib diisi");
            return;
        }

        double weight = Double.parseDouble(weightField.getText());
        int price = serviceBox.getSelectedItem().equals("Cuci Setrika") ? 8000 :
                serviceBox.getSelectedItem().equals("Express") ? 12000 : 6000;

        int total = (int) (weight * price);

        String[] data = {
                nameField.getText(),
                addressField.getText(),
                phoneField.getText(),
                dateField.getText(),
                serviceBox.getSelectedItem().toString(),
                weightField.getText(),
                "Rp " + String.format("%,d", total),
                statusBox.getSelectedItem().toString()
        };

        if (selectedRow == -1) {
            tablePanel.addRow(data);
        } else {
            tablePanel.updateRow(selectedRow, data);
        }

        clearForm();
        frame.showTable();
    }

    public void setFormData(String[] data, int row) {
        selectedRow = row;
        nameField.setText(data[0]);
        addressField.setText(data[1]);
        phoneField.setText(data[2]);
        dateField.setText(data[3]);
        serviceBox.setSelectedItem(data[4]);
        weightField.setText(data[5]);
        statusBox.setSelectedItem(data[7]);
    }

    private void clearForm() {
        selectedRow = -1;
        nameField.setText("");
        addressField.setText("");
        phoneField.setText("");
        dateField.setText("");
        weightField.setText("");
        serviceBox.setSelectedIndex(0);
        statusBox.setSelectedIndex(0);
    }

    private void style(JButton btn, Color c) {
        btn.setBackground(c);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setFocusPainted(false);
    }
}
