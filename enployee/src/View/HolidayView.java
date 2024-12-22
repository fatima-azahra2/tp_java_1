package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import Model.Holiday;
import Model.Holiday.HolidayType;

public class HolidayView extends JFrame {
    private JButton addButton, deleteButton, updateButton, listButton;
    private JTextField idField, nameField, startField, endField;
    private JComboBox<HolidayType> typeBox;
    private JTextArea displayArea;

    public HolidayView() {
        setTitle("Gestion des Congés");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Nom:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Type de Congé:"));
        typeBox = new JComboBox<>(HolidayType.values());
        inputPanel.add(typeBox);

        inputPanel.add(new JLabel("Date de Début (yyyy-MM-dd):"));
        startField = new JTextField();
        inputPanel.add(startField);

        inputPanel.add(new JLabel("Date de Fin (yyyy-MM-dd):"));
        endField = new JTextField();
        inputPanel.add(endField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Ajouter");
        buttonPanel.add(addButton);

        updateButton = new JButton("Modifier");
        buttonPanel.add(updateButton);

        deleteButton = new JButton("Supprimer");
        buttonPanel.add(deleteButton);

        listButton = new JButton("Lister");
        buttonPanel.add(listButton);

        add(buttonPanel, BorderLayout.CENTER);

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Succès", JOptionPane.INFORMATION_MESSAGE);
    }

    public void clearDisplayArea() {
        displayArea.setText("");
    }

    public void appendToDisplay(String text) {
        displayArea.append(text + "\n");
    }

    public HolidayType getHolidayType() {
        return (HolidayType) typeBox.getSelectedItem();
    }

    public JButton getAddButton() {
        return addButton;
    }
    
  

   
    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getListButton() {
        return listButton;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getStartField() {
        return startField;
    }

    public JTextField getEndField() {
        return endField;
    }

    public java.util.Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException ex) {
            return null;
        }
    }
}


