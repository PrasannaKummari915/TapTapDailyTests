package TapTapDailyCallenge;
import java.util.*;

public class SubtreeLabelCount {
    static List<List<Integer>> graph;
    static int[] result;
    static String labels;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of nodes
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Read edges as one line: [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]
        String edgesInput = sc.nextLine().replaceAll("[\\[\\]]", "");
        String[] edgePairs = edgesInput.split(",");

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < edgePairs.length; i += 2) {
            int u = Integer.parseInt(edgePairs[i].trim());
            int v = Integer.parseInt(edgePairs[i + 1].trim());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Labels string
        labels = sc.nextLine().replace("\"", "");

        result = new int[n];
        dfs(0, -1);

        System.out.println(Arrays.toString(result));
        sc.close();
    }

    private static int[] dfs(int node, int parent) {
        int[] freq = new int[26];
        char c = labels.charAt(node);
        freq[c - 'a']++;

        for (int child : graph.get(node)) {
            if (child == parent) continue;
            int[] childFreq = dfs(child, node);
            for (int i = 0; i < 26; i++) {
                freq[i] += childFreq[i];
            }
        }

        result[node] = freq[c - 'a'];
        return freq;
    }
}