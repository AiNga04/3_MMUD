package Main;

import javax.swing.*;
import java.io.*;
import java.math.BigInteger;

public class DigitalSignature {
    // Method to check if a number is prime
    private static boolean isPrime(BigInteger num) {
        // Check if num is less than 2
        if (num.compareTo(BigInteger.valueOf(2)) < 0) {
            return false;
        }
        
        // Check divisibility by numbers from 2 to sqrt(num)
        for (BigInteger i = BigInteger.valueOf(2); i.multiply(i).compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
            if (num.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        
        return true;
    }

    // Method to compute signature
    private static BigInteger computeSignature(BigInteger message, BigInteger p, BigInteger q, BigInteger d) {
        BigInteger n = p.multiply(q);
        return message.modPow(d, n);
    }

    // Method to write results to file
    private static void writeResultsToFile(String outputFile, BigInteger message, BigInteger signature, BigInteger p, BigInteger q, BigInteger d) throws IOException {
        BigInteger n = p.multiply(q);
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write("Message: " + message + "\n");
        writer.write("Signature: " + signature + "\n");
        writer.write("Public Key: (" + n + ", " + d.modInverse(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))) + ")\n");
        writer.write("Private Key: (" + d + ")\n");
        writer.write("Signed: " + signature + "\n");
        writer.close();
        System.out.println("Signature computation and output completed successfully.");
    }

    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "src//Main//input.txt";
        String outputFile = "src//Main//output.txt";
        BigInteger publicKeyN, publicKeyE;

        try {
            File selectedFile = null;
            boolean fileSelected = false;

            while (!fileSelected) {
                // Choose input file using JFileChooser
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    fileSelected = true;
                } else {
                    System.out.println("No file selected.");
                    int choice = JOptionPane.showConfirmDialog(null, "Do you want to choose a file again?", "Choose File", JOptionPane.YES_NO_OPTION);
                    if (choice != JOptionPane.YES_OPTION) {
                        return;
                    }
                }
            }

            // Input p, q, d using JOptionPane
            BigInteger p = new BigInteger(JOptionPane.showInputDialog("Enter value for p:"));
            BigInteger q = new BigInteger(JOptionPane.showInputDialog("Enter value for q:"));
            
            // Check if p and q are prime
            if (!isPrime(p) || !isPrime(q)) {
                System.out.println("Error: p and q must be prime numbers.");
                return;
            }

            BigInteger d = new BigInteger(JOptionPane.showInputDialog("Enter value for d:"));

            // Read message from file
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
            StringBuilder messageBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                messageBuilder.append(line);
            }
            reader.close();

            // Convert message to BigInteger
            BigInteger message = new BigInteger(messageBuilder.toString());

            // Compute signature
            BigInteger signature = computeSignature(message, p, q, d);

            // Write results to file
            writeResultsToFile(outputFile, message, signature, p, q, d);
            
            // Show results
            JOptionPane.showMessageDialog(null, "Signature: " + signature, "Digital Signature", JOptionPane.INFORMATION_MESSAGE);
            publicKeyN = p.multiply(q);
            publicKeyE = d.modInverse(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
            JOptionPane.showMessageDialog(null, "Public Key: (" + publicKeyN + ", " + publicKeyE + ")", "Digital Signature", JOptionPane.INFORMATION_MESSAGE);
            
            // Print signature and public key to console
            System.out.println("Signature: " + signature);
            System.out.println("Public Key: (" + publicKeyN + ", " + publicKeyE + ")");
            
            // Prompt user to choose input file again
            int chooseInputAgain = JOptionPane.showConfirmDialog(null, "Do you want to choose input file again for decryption?", "Choose Input File", JOptionPane.YES_NO_OPTION);
            if (chooseInputAgain == JOptionPane.YES_OPTION) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                } else {
                    System.out.println("No file selected.");
                    return;
                }
            }

            // Read message for decryption from the selected file
            reader = new BufferedReader(new FileReader(selectedFile));
            messageBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                messageBuilder.append(line);
            }
            reader.close();

            // Convert message for decryption to BigInteger
            message = new BigInteger(messageBuilder.toString());
            // Prompt user to enter n and e1
            BigInteger nForDecryption = new BigInteger(JOptionPane.showInputDialog("Enter value for key1 for decryption: \n"));
            BigInteger e1 = new BigInteger(JOptionPane.showInputDialog("Enter value for key2:\n"));

            // Perform decryption
            BigInteger decryptedMessage = signature.modPow(e1, nForDecryption);

            // Compare decrypted message with original message
            boolean decryptionMatches = decryptedMessage.equals(message);

            // Show decryption result
            if (decryptionMatches) {
                JOptionPane.showMessageDialog(null, "Decryption Matches Original Message: true", "Decryption Result", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Decryption Matches Original Message: true");
            } else {
                JOptionPane.showMessageDialog(null, "Decryption Matches Original Message: false", "Decryption Result", JOptionPane.ERROR_MESSAGE);
                System.out.println("Decryption Matches Original Message: false");
            }

            // Write decryption result to the output file
            BufferedWriter decryptionWriter = new BufferedWriter(new FileWriter(outputFile, true)); // Append mode
            decryptionWriter.write("Decrypted Message: " + decryptedMessage + "\n");
            decryptionWriter.write("Decryption Matches Original Message: " + decryptionMatches + "\n");
            decryptionWriter.close();      
            
            System.out.println("Decryption completed successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while reading/writing files.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        }
    }
}
