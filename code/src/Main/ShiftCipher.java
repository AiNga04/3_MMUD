package Main;

import java.util.Scanner;

public class ShiftCipher {
	public static String encrypt(String text, int shift) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (Character.isUpperCase(ch)) {
				result.append((char) (((ch - 'A' + shift) % 26) + 'A'));
			} else {
				result.append((char) (((ch - 'a' + shift) % 26) + 'a'));
			}
		}
		return result.toString();
	}

	public static String decrypt(String cipher, int shift) {
		return encrypt(cipher, 26 - shift);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text;
		System.out.println("Enter Text : ");
		text = sc.nextLine();
		int shift;
		System.out.println("Enter Shift");
		shift = sc.nextInt();
		String cipher = encrypt(text, shift);
		System.out.println("Bản mã: " + cipher);
		System.out.println("Bản rõ : " + decrypt(cipher, shift));
	}
}
