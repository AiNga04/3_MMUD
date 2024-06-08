package Main;

import java.util.Scanner;

public class MatKhoaChay {
	public static void heMatKhoaChay(String banRo, String key) {
		int i = 0;
		while (key.length() < banRo.length()) {
			key += banRo.charAt(i);
			i++;
		}
		String banMa = "";
		for (int j = 0; j < banRo.length(); j++) {
			int kiTuMoi = ((int) key.charAt(j) + (int) banRo.charAt(j));
			banMa += (char) ((kiTuMoi % 26) + 65);
		}
		System.out.println("He Mat Khoa Chay:");
		System.out.println("Key: " + key);
		System.out.println("Ban ma: " + banMa);

		banRo = "";
		int k = 0;
		while (key.length() < banMa.length()) {
			key += banMa.charAt(k);
			k++;
		}
		for (int j = 0; j < banMa.length(); j++) {
			int kiTuMoi = ((int) banMa.charAt(j) - (int) key.charAt(j) + 26) % 26;
			banRo += (char) (kiTuMoi + 65);
		}
		System.out.println("Giải mã Hệ Mật Khóa Chạy:");
		System.out.println("Key: " + key);
		System.out.println("Ban ro: " + banRo);
	}

	public static void giaiMaHeMatKhoaChay(String banMa, String key) {
		String banRo = "";
		int i = 0;
		while (key.length() < banMa.length()) {
			key += banMa.charAt(i);
			i++;
		}
		for (int j = 0; j < banMa.length(); j++) {
			int kiTuMoi = ((int) banMa.charAt(j) - (int) key.charAt(j) + 26) % 26;
			banRo += (char) (kiTuMoi + 65);
		}
		System.out.println("Giải mã Hệ Mật Khóa Chạy:");
		System.out.println("Key: " + key);
		System.out.println("Ban ma: " + banMa);
		System.out.println("Ban ro: " + banRo);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập key bản rõ: ");
		String banRo = scanner.next();
		System.out.print("Nhập key: ");
		String key = scanner.next();
		heMatKhoaChay(banRo, key);
	}

}
