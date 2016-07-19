import java.util.*;
public class LevelOrder {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.print(levelOrder(root) + "\n");
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}
		List<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		while (queue.size() > 0) {
			List<Integer> al = new ArrayList<Integer>();
			for (TreeNode node : queue) {
				al.add(node.val);
			}
			list.add(al);
			List<TreeNode> temp = queue;
			queue = new ArrayList<TreeNode>();
			for (TreeNode node : temp) {
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
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