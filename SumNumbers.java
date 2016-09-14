/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbersHelper(root, 0);
    }
    private int sumNumbersHelper(TreeNode root, int current) {
        int newCurrent = current * 10 + root.val;
        if (root.left == null && root.right == null) return newCurrent;
        else if (root.left == null) return sumNumbersHelper(root.right, newCurrent);
        else if (root.right == null) return sumNumbersHelper(root.left, newCurrent);
        return sumNumbersHelper(root.left, newCurrent) + sumNumbersHelper(root.right, newCurrent);
    }
}
