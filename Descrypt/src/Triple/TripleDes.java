package Triple;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class TripleDes {
    public static void main(String[] args)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException {
        String SECRET_KEY1 = "12345678";
        String SECRET_KEY2 = "abcdefgh";
        String SECRET_KEY3 = "ijklmnop"; // Thêm một khóa DES nữa

        // Ensure each key is 8 bytes (64 bits) long
        while (SECRET_KEY1.length() < 8) {
            SECRET_KEY1 += "0";
        }
        while (SECRET_KEY2.length() < 8) {
            SECRET_KEY2 += "0";
        }
        while (SECRET_KEY3.length() < 8) {
            SECRET_KEY3 += "0";
        }

        // Concatenate to create a 24-byte (192-bit) key for Triple DES
        String concatenatedKey = SECRET_KEY1 + SECRET_KEY2 + SECRET_KEY3;

        SecretKeySpec skeySpec = new SecretKeySpec(concatenatedKey.getBytes(), "DESede");

        String original = "stackjava.com";

        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");

        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] byteEncrypted = cipher.doFinal(original.getBytes());
        String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] byteDecrypted = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        String decrypted = new String(byteDecrypted);

        System.out.println("Original text: " + original);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}
