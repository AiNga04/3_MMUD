package mypack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RC4Swing extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField inputField, keyField;
    private JButton encryptButton, decryptButton;
    private JTextArea outputArea;

    public RC4Swing() {
        setTitle("RC4 Encryption/Decryption");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        JLabel inputLabel = new JLabel("Input:");
        inputField = new JTextField(20);

        JLabel keyLabel = new JLabel("Key:");
        keyField = new JTextField(20);

        topPanel.add(inputLabel);
        topPanel.add(inputField);
        topPanel.add(keyLabel);
        topPanel.add(keyField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String key = keyField.getText();
                String encrypted = RC4.encrypt(input, key);
                outputArea.setText("Encrypted: " + encrypted);
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String encrypted = outputArea.getText().replace("Encrypted: ", "");
                String key = keyField.getText();
                String decrypted = RC4.encrypt(encrypted, key);
                outputArea.append("\nDecrypted: " + decrypted);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RC4Swing().setVisible(true);
            }
        });
    }
}
