package TapTapDailyCallenge;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256Hash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();   // read dynamic input
        sc.close();

        try {
            // Create SHA-256 digest instance
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());

            // Convert bytes to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            System.out.println(hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("SHA-256 algorithm not found!");
        }
    }
}