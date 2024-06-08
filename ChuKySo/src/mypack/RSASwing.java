package mypack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class RSASwing extends JFrame implements ActionListener {

    private JLabel labelP, labelQ, labelMessage, labelSignature, labelResult;
    private JTextField textFieldP, textFieldQ, textFieldMessage, textFieldSignature;
    private JButton buttonSign, buttonVerify;

    public RSASwing() {
        setTitle("RSA Signature");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        labelP = new JLabel("Nhập giá trị p:");
        textFieldP = new JTextField(10);

        labelQ = new JLabel("Nhập giá trị q:");
        textFieldQ = new JTextField(10);

        labelMessage = new JLabel("Nhập thông điệp:");
        textFieldMessage = new JTextField(20);

        labelSignature = new JLabel("Nhập chữ ký:");
        textFieldSignature = new JTextField(20);

        buttonSign = new JButton("Ký");
        buttonSign.addActionListener(this);

        buttonVerify = new JButton("Xác minh");
        buttonVerify.addActionListener(this);

        labelResult = new JLabel();

        panel.add(labelP);
        panel.add(textFieldP);
        panel.add(labelQ);
        panel.add(textFieldQ);
        panel.add(labelMessage);
        panel.add(textFieldMessage);
        panel.add(labelSignature);
        panel.add(textFieldSignature);
        panel.add(buttonSign);
        panel.add(buttonVerify);
        panel.add(new JLabel()); // Empty space
        panel.add(labelResult);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSign) {
            sign();
        } else if (e.getSource() == buttonVerify) {
            verify();
        }
    }

    private void sign() {
        try {
            BigInteger p = new BigInteger(textFieldP.getText());
            BigInteger q = new BigInteger(textFieldQ.getText());
            BigInteger message = new BigInteger(textFieldMessage.getText());

            BigInteger n = p.multiply(q);
            BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
            BigInteger d = new BigInteger("223");
            BigInteger eValue = d.modInverse(phi);

            BigInteger signature = message.modPow(d, n);

            labelResult.setText("Chữ ký: " + signature);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nhập sai giá trị!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void verify() {
        try {
            BigInteger p = new BigInteger(textFieldP.getText());
            BigInteger q = new BigInteger(textFieldQ.getText());
            BigInteger n = p.multiply(q);
            BigInteger eValue = new BigInteger("367"); // Sử dụng giá trị e đã cho
            BigInteger message = new BigInteger(textFieldMessage.getText());
            BigInteger signature = new BigInteger(textFieldSignature.getText());

            BigInteger verified = signature.modPow(eValue, n);
            boolean isVerified = verified.equals(message);

            if (isVerified) {
                labelResult.setText("Kết quả kiểm tra chữ ký: Đúng");
            } else {
                labelResult.setText("Kết quả kiểm tra chữ ký: Sai");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nhập sai giá trị!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new RSASwing();
    }
}
