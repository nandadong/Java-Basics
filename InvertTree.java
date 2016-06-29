public class InvertTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		printTree(root);
		System.out.print("\n");
		printTree(invertTree(root));
		System.out.print("\n");
	}
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;

	}
	public static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val);
		System.out.print(" ");
		if (root.left != null) {
			printTree(root.left);
		}
		if (root.right != null) {
			printTree(root.right);
		}
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}