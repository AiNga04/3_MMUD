import java.math.BigInteger;
import java.util.Scanner;


public class Bai1 {

	static int mod = 26;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cipher = giaiMaVigenere("BNNIECQDZSSGHG", "CIPHER");
		String deciphered = giaiMaAffine(cipher, 7, 11);
		System.out.println("Encrypted: " + cipher);
		System.out.println("Decrypted: " + deciphered);
	}

	static String giaiMaAffine(String input, int firstKey, int secondKey) {
		StringBuilder builder = new StringBuilder();
		BigInteger inverse = BigInteger.valueOf(firstKey).modInverse(BigInteger.valueOf(mod));
		for (int in = 0; in < input.length(); in++) {
			char character = input.charAt(in);
			if (Character.isLetter(character)) {
				int decoded = inverse.intValue() * (character - 'A' - secondKey + mod);
				decoded = (decoded % mod + mod) % mod;
				character = (char) (decoded + 'A');
			}
			builder.append(character);
		}
		return builder.toString();
	}
	static String giaiMaVigenere(String chuoiDaMaHoa, String key) {
		StringBuilder chuoiGiaiMa = new StringBuilder();
		int doDaiKhoa = key.length();
		int doDaiChuoi = chuoiDaMaHoa.length();

		for (int i = 0; i < doDaiChuoi; i++) {
			char kyTuDaMaHoa = chuoiDaMaHoa.charAt(i);
			char kyTuKhoa = key.charAt(i % doDaiKhoa);

			if (Character.isLetter(kyTuDaMaHoa)) {
				char coSo = Character.isLowerCase(kyTuDaMaHoa) ? 'a' : 'A';
				int daGiaiMa = (kyTuDaMaHoa - kyTuKhoa + 26) % 26;
				char kyTuGiaiMa = (char) (daGiaiMa + coSo);
				chuoiGiaiMa.append(kyTuGiaiMa);
			} else {
				chuoiGiaiMa.append(kyTuDaMaHoa);
			}
		}
		return chuoiGiaiMa.toString();
	}
}