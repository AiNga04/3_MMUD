package DoubleDes;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Main {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		String SECRET_KEY1 = "12345678";
		String SECRET_KEY2 = "abcdefgh"; // Thêm một khóa DES nữa

		SecretKeySpec skeySpec1 = new SecretKeySpec(SECRET_KEY1.getBytes(), "DES");
		SecretKeySpec skeySpec2 = new SecretKeySpec(SECRET_KEY2.getBytes(), "DES"); // Khóa thứ hai

		String original = "stackjava.com";

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");

		// Mã hóa bằng khóa thứ nhất
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec1);
		byte[] byteEncrypted1 = cipher.doFinal(original.getBytes());

		// Mã hóa bằng khóa thứ hai
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec2);
		byte[] byteEncrypted2 = cipher.doFinal(byteEncrypted1);

		String encrypted = Base64.getEncoder().encodeToString(byteEncrypted2);

		// Giải mã bằng ngược lại với thứ tự khóa
		cipher.init(Cipher.DECRYPT_MODE, skeySpec2);
		byte[] byteDecrypted1 = cipher.doFinal(byteEncrypted2);

		cipher.init(Cipher.DECRYPT_MODE, skeySpec1);
		byte[] byteDecrypted2 = cipher.doFinal(byteDecrypted1);

		String decrypted = new String(byteDecrypted2);

		System.out.println("original  text: " + original);
		System.out.println("encrypted text: " + encrypted);
		System.out.println("decrypted text: " + decrypted);
	}
}