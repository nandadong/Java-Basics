import java.lang.*;
public class MaxDepth {
	public static void main(String[] args) {
		// TreeNode root = null;
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(7);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(6);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(4);
		System.out.println(maxDepth(root) + "\n");
	}
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null && root.right != null) {
			return maxDepth(root.right) + 1;
		}
		if (root.left != null && root.right == null) {
			return maxDepth(root.left) + 1;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }

}
