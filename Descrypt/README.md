# Mã hóa trong Java

Dự án này bao gồm các cài đặt của ba thuật toán mã hóa hiện đại bằng ngôn ngữ Java. Các thuật toán bao gồm:

1. [DES](#des)
2. [Double DES](#double-des)
3. [Triple DES](#triple-des)

## 1. Tiêu chuẩn mã hóa dữ liệu (DES)

### Mô tả
DES (Data Encryption Standard) là một thuật toán mã hóa khóa đối xứng dành cho việc mã hóa dữ liệu số. Nó được phát triển vào đầu những năm 1970 và được chấp nhận như một tiêu chuẩn liên bang ở Hoa Kỳ vào năm 1977. DES sử dụng một khóa dài 56 bit và hoạt động trên các khối dữ liệu 64 bit.

### Các bước của thuật toán
1. **Tạo khóa**: Một khóa dài 64 bit được sử dụng làm đầu vào, nhưng chỉ có 56 bit được sử dụng cho mã hóa (8 bit còn lại được sử dụng cho kiểm tra chẵn lẻ).
2. **Hoán vị ban đầu (IP)**: Khối văn bản rõ 64 bit được hoán vị bằng một bảng hoán vị cố định.
3. **Các vòng lặp**: DES thực hiện 16 vòng xử lý, mỗi vòng bao gồm:
    - **Mở rộng (E)**: Mở rộng nửa khối 32 bit thành 48 bit.
    - **Trộn khóa**: XOR khối đã mở rộng với một khóa con.
    - **Thay thế (S-boxes)**: Thay thế khối 48 bit bằng một khối 32 bit bằng các hộp thay thế.
    - **Hoán vị (P)**: Hoán vị khối 32 bit.
4. **Hoán vị cuối (FP)**: Kết quả nối của các vòng cuối cùng được hoán vị bằng một bảng cố định để tạo ra văn bản mã hóa.

### Sử dụng
DES được sử dụng trong các giao thức bảo mật khác nhau, bao gồm các phiên bản cũ hơn của SSL/TLS, và trong các dịch vụ tài chính để bảo vệ dữ liệu nhạy cảm.

Folder: `DES`

## 2. Double DES

### Mô tả
Double DES là một cải tiến của thuật toán DES nhằm tăng cường bảo mật bằng cách áp dụng thuật toán DES hai lần với hai khóa khác nhau. Độ dài khóa hiệu quả là 112 bit (56 bit mỗi khóa).

### Các bước của thuật toán
1. **Mã hóa lần đầu**: Mã hóa văn bản rõ bằng DES với khóa 56 bit đầu tiên (Key1).
2. **Mã hóa lần thứ hai**: Mã hóa kết quả của lần mã hóa đầu tiên bằng DES với khóa 56 bit thứ hai (Key2).

**Các bước chính của thuật toán:**

1. **Mã hóa lần đầu với Key1:**
### C1 = DES(Key1, P)

2. **Mã hóa lần thứ hai với Key2:**
### C = DES(Key2, C1)

### Sử dụng
Mặc dù có độ dài khóa tăng lên, Double DES vẫn dễ bị tấn công kiểu gặp giữa, làm cho nó kém an toàn hơn so với mục đích ban đầu.

Folder: `DoubleDES`

## 3. Triple DES (3DES)

### Mô tả
Triple DES (3DES hoặc TDES) cải thiện Double DES bằng cách áp dụng thuật toán DES ba lần với hai hoặc ba khóa, tăng cường bảo mật đáng kể. Có hai biến thể:

- **2-Key TDES**: Sử dụng hai khóa 56 bit.
- **3-Key TDES**: Sử dụng ba khóa 56 bit, cung cấp độ dài khóa 168 bit.

### Các bước của thuật toán

1. **Mã hóa lần đầu với Key1:**
### 𝐶1=𝐷𝐸𝑆(𝐾𝑒𝑦1,𝑃)
### C1=DES(Key1,P)

2. **Giải mã với Key2:**
### 𝐶2=𝐷𝐸𝑆−1(𝐾𝑒𝑦2,𝐶1)
### C2=DES−1
### (Key2,C1)

2. **Mã hóa lần thứ ba với Key3:***
### 𝐶=𝐷𝐸𝑆(𝐾𝑒𝑦3,𝐶2)
### C=DES(Key3,C2)

### Sử dụng
3DES được sử dụng rộng rãi trong nhiều ứng dụng, bao gồm các giao dịch tài chính (ví dụ: hệ thống thanh toán) và trong các giao thức như IPsec.

## Kết luận
Mặc dù DES đã đặt nền móng cho mã hóa khóa đối xứng, sự dễ bị tấn công kiểu brute-force của nó đã dẫn đến sự phát triển của các biến thể bảo mật hơn như Double DES và Triple DES. Mặc dù đã bị thay thế bởi các thuật toán hiện đại hơn như AES, việc hiểu DES và các cải tiến của nó là rất quan trọng cho mục đích lịch sử và giáo dục trong lĩnh vực mật mã.

Folder: 'Triple'