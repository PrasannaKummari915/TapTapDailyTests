package TapTapDailyCallenge;
import java.util.*;

public class DiffWaysToAddParanthesis {
    private static Map<String, List<Integer>> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read safely: handle both quoted and unquoted input
        String expression = "";
        if (sc.hasNext()) {
            expression = sc.next().trim();
        }
        // Remove quotes if present
        if (expression.startsWith("\"") && expression.endsWith("\"")) {
            expression = expression.substring(1, expression.length() - 1);
        }

        List<Integer> results = diffWaysToCompute(expression);

        // Always print a list
        System.out.println(results);

        sc.close();
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> res = new ArrayList<>();

        // Base case: if the expression is just a number
        if (expression.matches("\\d+")) {
            res.add(Integer.parseInt(expression));
            memo.put(expression, res);
            return res;
        }

        // Try splitting at each operator
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (c == '+') res.add(l + r);
                        else if (c == '-') res.add(l - r);
                        else if (c == '*') res.add(l * r);
                    }
                }
            }
        }

        memo.put(expression, res);
        return res;
    }
}