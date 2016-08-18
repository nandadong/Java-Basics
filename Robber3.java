import java.util.*;
public class Robber3 {
	private static Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(18);
		root.left.right = new TreeNode(23);
		root.right.right = new TreeNode(1);
		System.out.println(rob(root));
	}
	public static int rob(TreeNode root) {
		if (root == null) 
			return 0;
		if (map.containsKey(root))
			return map.get(root);
		int val = 0;
		if (root.left != null)
			val += rob(root.left.left) + rob(root.left.right);
		if (root.right != null)
			val += rob(root.right.left) + rob(root.right.right);
		val = Math.max(val + root.val, rob(root.left) + rob(root.right));
		map.put(root, val);
		return val;
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}