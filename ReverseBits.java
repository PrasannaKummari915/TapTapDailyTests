package TapTapDailyCallenge;
import java.util.Scanner;

public class ReverseBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read integer input dynamically
        int n = sc.nextInt();

        // Reverse the bits
        int reversed = reverseBits(n);

        // Print the result
        System.out.println(reversed);

        sc.close();
    }

    // Function to reverse bits of a 32-bit integer
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result left and add the last bit of n
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }
}