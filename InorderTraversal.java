import java.util.*;
public class InorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(inorderTraversal(root));
	}
	/***Trivial recursive solution***/
	/*
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) return list;
		inorderHelper(root, list);
		return list;
	}
	private static void inorderHelper(TreeNode root, List<Integer> list) {
		if (root.left != null) inorderHelper(root.left, list);
		list.add(root.val);
		if (root.right != null) inorderHelper(root.right, list);
	}
	*/
	/***Iterative solution***/
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			root = stack.peek();
			if (root.left != null) {
				stack.push(root.left);
				root.left = null;
				continue;
			}
			list.add(root.val);
			stack.pop();
			if (root.right != null) {
				stack.push(root.right);
				root.right = null;
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