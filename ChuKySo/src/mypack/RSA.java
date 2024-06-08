package mypack;

import java.math.BigInteger;
import java.util.Scanner;

public class RSA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá trị p: ");
        BigInteger p = scanner.nextBigInteger();

        System.out.print("Nhập giá trị q: ");
        BigInteger q = scanner.nextBigInteger();

        System.out.print("Nhập thông điệp: ");
        BigInteger message = scanner.nextBigInteger();

        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger d = new BigInteger("223"); 
        BigInteger e = d.modInverse(phi);

        BigInteger signature = message.modPow(d, n);

        BigInteger publicKey = n.multiply(e);
        BigInteger privateKey = d;

        System.out.println("Thông điệp: " + message);
        System.out.println("Chữ ký: " + signature);
        System.out.println("Công khai: (" + n + ", " + e + ")");
        System.out.println("Bí mật: (" + d + ")");

        BigInteger verified = signature.modPow(e, n);
        System.out.println("Ký: " + message);
        System.out.println("Kiểm tra chữ ký: " + verified);
        System.out.println("Kết quả kiểm tra chữ ký: " + verified.equals(message));

        scanner.close();
    }
}
