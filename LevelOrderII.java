import java.util.*;
public class LevelOrderII {
	public static void main(String[] args) {
			TreeNode root = new TreeNode(3);
			root.left = new TreeNode(9);
			root.left.left = new TreeNode(5);
			root.left.right = new TreeNode(6);
			root.right = new TreeNode(20);
			root.right.left = new TreeNode(15);
			root.right.right = new TreeNode(7);

			List<List<Integer>> l = levelOrderBottom(root);
			System.out.print(l + "\n");
	}
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}
		List<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		while (queue.size() > 0) {
			List<Integer> current = new ArrayList<Integer>();
			for (TreeNode child : queue) {
				current.add(child.val);
			}

			list.add(0, current);
			List<TreeNode> temp = queue;
			queue = new ArrayList<TreeNode>();
			for (TreeNode child : temp) {
				if (child.left != null) {
					queue.add(child.left);
				}
				if (child.right != null) {
					queue.add(child.right);
				}
			}

		}
		return list;
	}
	
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}