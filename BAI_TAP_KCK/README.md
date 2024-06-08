# Các Thuật Toán Mật Mã

## Mục đích

File README này cung cấp một tóm tắt về các thuật toán mật mã phổ biến như ElGamal, Eliptic, Merkle-Hellman, Rabin và RSA. Mỗi phần sẽ mô tả ngắn gọn về thuật toán, cách thức hoạt động và ứng dụng.

## ElGamal

### Mô tả
ElGamal là một thuật toán mật mã hệ mở khóa (public-key) dựa trên toán học modulô. Nó được sử dụng cho việc mã hóa và ký điện tử.

### Hoạt động
1. Khóa công khai được sử dụng để mã hóa dữ liệu.
2. Khóa bí mật được sử dụng để giải mã dữ liệu.

### Ứng dụng
- Bảo mật trong truyền tin qua mạng.
- Ký và xác thực số.

## Eliptic
*(Assuming Elliptic Curve Cryptography)*

### Mô tả
Eliptic là một thuật toán mật mã dựa trên các điểm trên các đường cong elip. Nó cung cấp mức độ bảo mật cao và hiệu suất tốt so với một số thuật toán khác.

### Hoạt động
1. Dùng toán học modulo và điểm trên đường cong elip để thực hiện các phép tính mật mã.
2. Thực hiện các phép toán như cộng, nhân, và tính nghịch đảo theo quy tắc đặc biệt của đường cong elip.

### Ứng dụng
- Bảo mật dữ liệu trong các ứng dụng blockchain.
- Tạo chữ ký điện tử.

## Merkle-Hellman

### Mô tả
Merkle-Hellman là một thuật toán mật mã hệ khóa bí mật (private-key) được sử dụng cho việc mã hóa dữ liệu.

### Hoạt động
1. Tạo một chuỗi các số nguyên ngẫu nhiên và tính tổng của chúng.
2. Sử dụng phương trình đệ quy để tạo ra một chuỗi khóa công khai từ chuỗi tổng đó.
3. Sử dụng thuật toán knapsack để mã hóa và giải mã dữ liệu.

### Ứng dụng
- Mã hóa và giải mã dữ liệu trong các hệ thống không công khai.

## Rabin

### Mô tả
Rabin là một thuật toán mật mã hệ mở khóa dựa trên việc tìm số nguyên tố lớn.

### Hoạt động
1. Chọn ba số nguyên tố p, q và m.
2. Tính n = pq và sử dụng n làm khóa công khai.
3. Tính p và q từ n để tạo khóa bí mật.

### Ứng dụng
- Mã hóa và giải mã dữ liệu trong bảo mật thông tin.

## RSA

### Mô tả
RSA là một thuật toán mật mã hệ mở khóa phổ biến và mạnh mẽ.

### Hoạt động
1. Chọn hai số nguyên tố lớn p và q.
2. Tính n = pq và sử dụng n làm khóa công khai.
3. Tính φ(n) và chọn một số e sao cho e và φ(n) là số nguyên tố cùng nhau.
4. Tính d sao cho (ed - 1) chia hết cho φ(n), sử dụng d làm khóa bí mật.

### Ứng dụng
- Bảo mật truyền tin qua mạng.
- Ký và xác thực số.

## Kết Luận

Các thuật toán mật mã trên đều có vai trò quan trọng trong bảo mật thông tin. Việc hiểu cách chúng hoạt động và ứng dụng của chúng sẽ giúp cho việc triển khai bảo mật hiệu quả hơn trong các hệ thống và ứng dụng.
