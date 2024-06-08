package mypack;
public class RC4 {
    public static String encrypt(String input, String key) {
    	StringBuilder result = new StringBuilder();
        int x, y, j = 0;
        int[] box = new int[256];

        for (int i = 0; i < 256; i++) {
            box[i] = i;
        }

        for (int i = 0; i < 256; i++) {
            j = (key.charAt(i % key.length()) + box[i] + j) % 256;
            x = box[i];
            box[i] = box[j];
            box[j] = x;
            System.out.println("j: " + j + " x:" + x + "box[i]: " + box[i] + " box[j]:" + box[j]);
        }

        for (int i = 0; i < input.length(); i++) {
            y = i % 256;
            j = (box[y] + j) % 256;
            x = box[y];
            box[y] = box[j];
            box[j] = x;

            result.append((char) (input.charAt(i) ^ box[(box[y] + box[j]) % 256]));
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        String input = "TruongAiNga";
        String key = "SecretKey";

        String encrypted = RC4.encrypt(input, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = RC4.encrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);
    }
}