
import java.util.Scanner;

public class Bai2 {
    public static int[][] inverseMatrix(int[][] matrix) {
        int determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        int modInverse = multiplicativeInverse(determinant, 26);
        int[][] identityTranspose = {{matrix[1][1], -matrix[0][1]}, 
        		{-matrix[1][0], matrix[0][0]}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                identityTranspose[i][j] = (identityTranspose[i][j] * modInverse) % 26;
                if (identityTranspose[i][j] < 0) {
                    identityTranspose[i][j] += 26;
                }
            }
        }
        return identityTranspose;
    }
    
    public static int multiplicativeInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return 1;
    }
    public static String hillDecryption(String ciphertext, int[][] keyMatrix) {
        StringBuilder plaintext = new StringBuilder();
        int[][] inverseKeyMatrix = inverseMatrix(keyMatrix);
        for (int i = 0; i < ciphertext.length(); i += 2) {
            int[] cipherPair = {ciphertext.charAt(i) - 'A', ciphertext.charAt(i + 1) - 'A'};
            int[] plainPair = new int[2];
            for (int j = 0; j < 2; j++) {
                plainPair[j] = (inverseKeyMatrix[j][0] * cipherPair[0] 
                		+ inverseKeyMatrix[j][1] * cipherPair[1]) % 26;
                if (plainPair[j] < 0) {
                    plainPair[j] += 26;
                }
            }
            plaintext.append((char) (plainPair[0] + 'A')).append((char) (plainPair[1] + 'A'));
        }

        return plaintext.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ciphertext = "QQCDUK";
        System.out.println("Encrypted: " + ciphertext);
        int[][] keyMatrix = {{5, 8}, {12, 9}};
        String plaintext = hillDecryption(ciphertext, keyMatrix);
        System.out.println("Decrypted: " + plaintext);
        scanner.close();
    }
}
