package mypack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class ElGamalSwing extends JFrame implements ActionListener {

    private JLabel labelP, labelAlpha, labelA, labelX, labelK, labelResult;
    private JTextField textFieldP, textFieldAlpha, textFieldA, textFieldX, textFieldK;
    private JButton buttonSign, buttonVerify;

    public ElGamalSwing() {
        setTitle("ElGamal Signature");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 5, 5));

        labelP = new JLabel("Nhập giá trị p:");
        textFieldP = new JTextField(10);

        labelAlpha = new JLabel("Nhập giá trị alpha:");
        textFieldAlpha = new JTextField(10);

        labelA = new JLabel("Nhập giá trị a:");
        textFieldA = new JTextField(10);

        labelX = new JLabel("Nhập giá trị x:");
        textFieldX = new JTextField(10);

        labelK = new JLabel("Nhập giá trị k:");
        textFieldK = new JTextField(10);

        buttonSign = new JButton("Ký");
        buttonSign.addActionListener(this);

        buttonVerify = new JButton("Xác minh");
        buttonVerify.addActionListener(this);

        labelResult = new JLabel();

        panel.add(labelP);
        panel.add(textFieldP);
        panel.add(labelAlpha);
        panel.add(textFieldAlpha);
        panel.add(labelA);
        panel.add(textFieldA);
        panel.add(labelX);
        panel.add(textFieldX);
        panel.add(labelK);
        panel.add(textFieldK);
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
            BigInteger alpha = new BigInteger(textFieldAlpha.getText());
            BigInteger a = new BigInteger(textFieldA.getText());
            BigInteger x = new BigInteger(textFieldX.getText());
            BigInteger k = new BigInteger(textFieldK.getText());

            ElGamalSignature elGamal = new ElGamalSignature(p, alpha, a);

            BigInteger[] signature = elGamal.sign(x, k);
            labelResult.setText("Chữ ký: (r, s) = (" + signature[0] + ", " + signature[1] + ")");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nhập sai giá trị!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void verify() {
        try {
            BigInteger p = new BigInteger(textFieldP.getText());
            BigInteger alpha = new BigInteger(textFieldAlpha.getText());
            BigInteger a = new BigInteger(textFieldA.getText());
            BigInteger x = new BigInteger(textFieldX.getText());
            BigInteger k = new BigInteger(textFieldK.getText());

            ElGamalSignature elGamal = new ElGamalSignature(p, alpha, a);

            BigInteger[] signature = elGamal.sign(x, k);
            BigInteger y = alpha.modPow(a, p);

            boolean isVerified = elGamal.verify(x, signature[0], signature[1], y);
            labelResult.setText("Chữ ký có hợp lệ: " + isVerified);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nhập sai giá trị!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new ElGamalSwing();
    }
}
