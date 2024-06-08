package Main;

public class VigenereCipherJava {
	public static String maHoa(String banRo, String key) {
		StringBuilder chuoiDaMaHoa = new StringBuilder();
		int doDaiKhoa = key.length();
		int doDaiBanRo = banRo.length();

		for (int i = 0; i < doDaiBanRo; i++) {
			char kyTuBanRo = banRo.charAt(i);
			char kyTuKhoa = key.charAt(i % doDaiKhoa);

			if (Character.isLetter(kyTuBanRo)) {
				char coSo = Character.isLowerCase(kyTuBanRo) ? 'a' : 'A';
				int daMaHoa = (kyTuBanRo + kyTuKhoa - 2 * coSo) % 26;
				char kyTuDaMaHoa = (char) (daMaHoa + coSo);
				chuoiDaMaHoa.append(kyTuDaMaHoa);
			} else {
				chuoiDaMaHoa.append(kyTuBanRo);
			}
		}

		return chuoiDaMaHoa.toString();
	}
	
	public static String giaiMa(String chuoiDaMaHoa, String key) {
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

	public static void main(String[] args) {
		String banRo = "TRUONGAINGA";
		String key = "NGA";

		String chuoiDaMaHoa = maHoa(banRo, key);
		System.out.println("Bản rõ: " + banRo);
		System.out.println("Key: " + key);
		System.out.println("Chuỗi đã mã hóa: " + chuoiDaMaHoa);

		String chuoiGiaiMa = giaiMa(chuoiDaMaHoa, key);
		System.out.println("Bản mã: " + chuoiDaMaHoa);
		System.out.println("Key: " + key);
		System.out.println("Chuỗi đã giải mã: " + chuoiGiaiMa);
	}
}
