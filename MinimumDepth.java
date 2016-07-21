public class MinimumDepth {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);

		System.out.print(minDepth(root) + "\n");
	}
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return 1 + minDepth(root.right);
		}
		if (root.right == null) {
			return 1 + minDepth(root.left);
		}
		return 1 + Math.min(minDepth(root.left),minDepth(root.right));
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}