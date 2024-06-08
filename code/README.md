# Mã hóa cổ điển trong Java

Dự án này bao gồm các cài đặt của năm thuật toán mã hóa cổ điển bằng ngôn ngữ Java. Các thuật toán bao gồm:

1. [Affine Cipher](#affine-cipher)
2. [Hill Cipher](#hill-cipher)
3. [Mã khóa chạy (One-time Pad)](#mã-khóa-chạy-one-time-pad)
4. [Shift Cipher (Caesar Cipher)](#shift-cipher-caesar-cipher)
5. [Vigenère Cipher](#vigenère-cipher)

## Affine Cipher

Affine Cipher là một loại mã hóa thay thế, trong đó mỗi ký tự trong bản rõ được ánh xạ tới một ký tự mã hóa thông qua một công thức toán học.

**Công thức mã hóa:**
### E(x) = (ax + b) mod m

**Công thức giải mã:**
### D(x) = a⁻¹(x - b) mod m


File: `AffineCipher.java`

## Hill Cipher

Hill Cipher là một hệ thống mã hóa khối, trong đó mỗi ký tự của văn bản gốc được mã hóa thành một khối ký tự thông qua phép nhân ma trận.

**Công thức mã hóa:**
### E(K, P) = KP mod 26


**Công thức giải mã:**
### D(K, C) = K⁻¹C mod 26


File: `HillCipher.java`

## Mã khóa chạy (One-time Pad)

One-time Pad là một hệ thống mã hóa không thể phá vỡ nếu khóa được sử dụng chỉ một lần và bí mật tuyệt đối.

**Công thức mã hóa:**
### C = P ⊕ K


**Công thức giải mã:**
### P = C ⊕ K

File: `MatKhoaChay.java`

## Shift Cipher (Caesar Cipher)

Shift Cipher, còn được biết đến là Caesar Cipher, là một loại mã hóa thay thế đơn giản, trong đó mỗi ký tự trong bản rõ được thay thế bởi một ký tự cách nó một khoảng cố định trong bảng chữ cái.

**Công thức mã hóa:**
### E(x) = (x + n) mod 26


**Công thức giải mã:**
### D(x) = (x - n + 26) mod 26

File: `ShiftCipher.java`

## Vigenère Cipher

Vigenère Cipher là một phương pháp mã hóa dựa trên việc sử dụng một từ khóa để điều chỉnh cách dịch chuyển của mỗi ký tự trong bản rõ.

**Công thức mã hóa:**
### E(xᵢ) = (xᵢ + kᵢ % m) mod 26

**Công thức giải mã:**
### D(xᵢ) = (xᵢ - kᵢ % m + 26) mod 26

File: `VigenereCipher.java`


