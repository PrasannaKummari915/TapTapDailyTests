package TapTapDailyCallenge;
import java.util.*;

public class ConcatenateStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the whole line of input
        String line = sc.nextLine();

        // Split by spaces into an array
        String[] arr = line.split("\\s+");

        // Concatenate using StringBuilder
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            if (s != null && !s.isEmpty()) {
                result.append(s);
            }
        }

        System.out.println(result.toString());
        sc.close();
    }
}