package TapTapDailyCallenge;
import java.util.Scanner;

public class BinaryGap {
    public static int binaryGap(int n) {
        int last = -1;   // position of last '1'
        int maxGap = 0;  // longest distance found
        int pos = 0;     // current bit position

        while (n > 0) {
            if ((n & 1) == 1) { // check if current bit is 1
                if (last != -1) {
                    maxGap = Math.max(maxGap, pos - last);
                }
                last = pos;
            }
            n >>= 1; // move to next bit
            pos++;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        int result = binaryGap(n);
        System.out.println("Longest binary gap: " + result);

        sc.close();
    }
}