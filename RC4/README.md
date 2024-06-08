# Thuật toán RC4

RC4 (Rivest Cipher 4) là một thuật toán mã hóa dòng do Ron Rivest phát triển vào năm 1987. Nó được sử dụng rộng rãi trong các giao thức và ứng dụng như SSL/TLS và WEP/WPA cho bảo mật mạng không dây. RC4 hoạt động bằng cách tạo ra một khóa dài và sử dụng nó để tạo ra một dòng khóa pseudorandom, dòng này sau đó được XOR với văn bản rõ để tạo ra văn bản mã hóa.

## Các bước của thuật toán

### 1. Khởi tạo trạng thái khóa (KSA - Key Scheduling Algorithm)

Khởi tạo một mảng S của tất cả các giá trị có thể của byte (0-255). Sau đó, hoán vị các giá trị này dựa trên khóa.

### 2. Tạo dòng khóa (PRGA - Pseudo-Random Generation Algorithm)

Sử dụng mảng S để tạo ra dòng khóa pseudorandom, sau đó XOR dòng khóa này với văn bản rõ để tạo ra văn bản mã hóa.

### Mã hóa và giải mã
Văn bản rõ được mã hóa bằng cách XOR nó với dòng khóa. Giải mã được thực hiện theo cùng một cách, vì việc XOR với cùng một giá trị hai lần sẽ trả về giá trị ban đầu.

#### Công thức mã hóa và giải mã:
**Ciphertext = Plaintext ⊕ KeystreamCiphertext = Plaintext⊕Keystream**

File: RC4.java