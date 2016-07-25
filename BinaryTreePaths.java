import java.util.*;
public class BinaryTreePaths {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		System.out.print(binaryTreePaths(root) + "\n");
	}
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if (root == null) {
			return list;	
		}
		binaryTreePathsHelper(root, list, "");
		return list;
	}
	public static void binaryTreePathsHelper(TreeNode root, List<String> list, String path) {
		if (path == "") {
			path += root.val;
		} else {
			path += "->" + root.val;
		}
		if (root.left == null && root.right == null) {
			list.add(path);
		} else if (root.left == null) {
			binaryTreePathsHelper(root.right, list, path);
		} else if (root.right == null) {
			binaryTreePathsHelper(root.left, list, path);
		} else {
			binaryTreePathsHelper(root.left, list, path);
			binaryTreePathsHelper(root.right, list, path);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}