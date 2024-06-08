package mypack;

import java.math.BigInteger;
import java.util.Scanner;

public class ElGamalSignature {
    private BigInteger p, alpha, a;

    public ElGamalSignature(BigInteger p, BigInteger alpha, BigInteger a) {
        this.p = p;
        this.alpha = alpha;
        this.a = a;
    }

    public BigInteger[] sign(BigInteger x, BigInteger k) {
        BigInteger r = alpha.modPow(k, p);
        BigInteger s = k.modInverse(p.subtract(BigInteger.ONE)).multiply(x.subtract(a.multiply(r))).mod(p.subtract(BigInteger.ONE));

        return new BigInteger[]{r, s};
    }

    public boolean verify(BigInteger x, BigInteger r, BigInteger s, BigInteger y) {
        BigInteger v1 = y.modPow(r, p).multiply(r.modPow(s, p)).mod(p);
        BigInteger v2 = alpha.modPow(x, p);

        return v1.equals(v2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá trị p: ");
        BigInteger p = scanner.nextBigInteger();

        System.out.print("Nhập giá trị alpha: ");
        BigInteger alpha = scanner.nextBigInteger();

        System.out.print("Nhập giá trị a: ");
        BigInteger a = scanner.nextBigInteger();

        System.out.print("Nhập giá trị x: ");
        BigInteger x = scanner.nextBigInteger();

        System.out.print("Nhập giá trị k: ");
        BigInteger k = scanner.nextBigInteger();

        scanner.close();
        
        ElGamalSignature elGamal = new ElGamalSignature(p, alpha, a);
        
        BigInteger[] signature = elGamal.sign(x, k);
        System.out.println("Chữ ký: (r, s) = (" + signature[0] + ", " + signature[1] + ")");
        
        BigInteger y = alpha.modPow(a, p);

        boolean isVerified = elGamal.verify(x, signature[0], signature[1], y);
        System.out.println("Chữ ký có hợp lệ " + isVerified);
    }
}
