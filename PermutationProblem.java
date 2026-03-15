package TapTapDailyCallenge;
import java.util.*;
public class PermutationProblem {


	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Dynamic input: first the string, then k
	        String s = sc.next();
	        int k = sc.nextInt();

	        // Convert string to char array and sort for lexicographic order
	        char[] chars = s.toCharArray();
	        Arrays.sort(chars);

	        // Generate permutations
	        List<String> result = new ArrayList<>();
	        boolean[] used = new boolean[chars.length];
	        backtrack(chars, k, new StringBuilder(), used, result);

	        // Print results
	        for (String perm : result) {
	            System.out.println(perm);
	        }
	    }

	    private static void backtrack(char[] chars, int k, StringBuilder current,
	                                  boolean[] used, List<String> result) {
	        if (current.length() == k) {
	            result.add(current.toString());
	            return;
	        }

	        for (int i = 0; i < chars.length; i++) {
	            if (used[i]) continue;
	            used[i] = true;
	            current.append(chars[i]);
	            backtrack(chars, k, current, used, result);
	            current.deleteCharAt(current.length() - 1);
	            used[i] = false;
	        }
	    }
	}
