package Main;

import java.math.BigInteger;
import java.util.Scanner;

public class AffineCipher {

	static int mod = 26;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the source text: ");
		String source = sc.nextLine().toUpperCase();

		System.out.println("Enter key1: ");
		int key1 = sc.nextInt();

		System.out.println("Enter key2: ");
		int key2 = sc.nextInt();

		String cipher = encrypt(source, key1, key2);
		String deciphered = decrypt(cipher, key1, key2);

		System.out.println("Source:    " + source);
		System.out.println("Encrypted: " + cipher);
		System.out.println("Decrypted: " + deciphered);
	}

	static String encrypt(String input, int firstKey, int secondKey) {
		StringBuilder builder = new StringBuilder();
		for (int in = 0; in < input.length(); in++) {
			char character = input.charAt(in);
			if (Character.isLetter(character)) {
				character = (char) ((firstKey * (character - 'A') + secondKey) % mod + 'A');
			}
			builder.append(character);
		}
		return builder.toString();
	}

	static String decrypt(String input, int firstKey, int secondKey) {
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
}
