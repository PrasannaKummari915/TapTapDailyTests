package TapTapDailyCallenge;
import java.util.*;

public class ShortestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Handle multiple test cases until EOF
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (s.isEmpty()) continue;

            // Remove quotes if input is like "abcd"
            if (s.startsWith("\"") && s.endsWith("\"")) {
                s = s.substring(1, s.length() - 1);
            }

            System.out.println(shortestPalindrome(s));
        }

        sc.close();
    }

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        // Compute prefix function (KMP table)
        int[] lps = new int[combined.length()];
        for (int i = 1; i < combined.length(); i++) {
            int j = lps[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        // Longest palindrome prefix length
        int longestPrefix = lps[combined.length() - 1];

        // Only reverse the non-palindromic suffix
        String suffix = s.substring(longestPrefix);

        return new StringBuilder(suffix).reverse().toString() + s;
    }
}