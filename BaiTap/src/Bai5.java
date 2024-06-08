import javax.crypto.SecretKey;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.KeyGenerator;


public class Bai5 {
    private SecretKey key;
    private final int TLEN = 128;
    private Cipher encryptionCipher;
    private final int KEYSIZE = 128;
    

    public void init() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEYSIZE);
        key = generator.generateKey();
    }   

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] messageInBytes = decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(TLEN, encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
        return new String(decryptedBytes);
    }
    
    public String encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
        return encode(encryptedBytes);
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public static void main(String[] args) {
        try {
            Bai5 aes = new Bai5();
            aes.init();
            String encryptedMessage = aes.encrypt("TheXCoders");
            String decryptedMessage = aes.decrypt(encryptedMessage);
            System.out.println("Encrypted Message : " + encryptedMessage);
            System.out.println("Decrypted Message : " + decryptedMessage);
        } 
        catch (Exception ignored) {
        }
    }
}
