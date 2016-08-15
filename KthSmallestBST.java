import java.util.*;
public class KthSmallestBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		int k = 7;
		System.out.println(kthSmallest(root, k));
	}
	/** Weird solution first come up with***/
	/*
	public static int kthSmallest(TreeNode root, int k) {
		Stack<Integer> stack = new Stack<Integer>();
		int value = 0;
		try {
			kthSmallestHelper(root, k, stack);
		} catch (Exception e) {
			value = stack.peek();
		}
		return value;
	}
	private static void kthSmallestHelper(TreeNode root, int k, Stack<Integer> stack) throws Exception{
		if (root.left != null) kthSmallestHelper(root.left, k, stack);
		stack.push(root.val);
		if (stack.size() == k) throw new Exception();
		if (root.right != null) kthSmallestHelper(root.right, k, stack);
	}
	*/
	private static int number = 0;
	private static int count = 0;
	public static int kthSmallest(TreeNode root, int k) {
		count = k;
		kthSmallestHelper(root);
		return number;
	}
	private static void kthSmallestHelper(TreeNode root) {
		if (root.left != null) kthSmallestHelper(root.left);
		if (--count == 0) {
			number = root.val;
			return;
		}
		if (root.right != null) kthSmallestHelper(root.right);
	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}