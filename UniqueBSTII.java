package TapTapDailyCallenge;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }


public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Pick each number as root
        for (int i = start; i <= end; i++) {
            // Generate all possible left subtrees
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            // Generate all possible right subtrees
            List<TreeNode> rightTrees = buildTrees(i + 1, end);

            // Combine left and right with current root
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }

    // Helper to print trees in level-order for debugging
    private String serialize(TreeNode root) {
        if (root == null) return "null";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.add("null");
                continue;
            }
            res.add(String.valueOf(node.val));
            q.add(node.left);
            q.add(node.right);
        }
        // Trim trailing nulls
        int i = res.size() - 1;
        while (i >= 0 && res.get(i).equals("null")) i--;
        return res.subList(0, i + 1).toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        UniqueBSTII obj = new UniqueBSTII();
        List<TreeNode> trees = obj.generateTrees(n);

        // Print all trees
        for (TreeNode root : trees) {
            System.out.println(obj.serialize(root));
        }
    }
}
}