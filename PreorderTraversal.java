import java.util.*;
public class PreorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(2);
		// root.right.left = new TreeNode(3);
		System.out.println(preorderTraversal(root));
	}
	/***	Trivial recursive solution
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorderHelper(root, list);
        return list;
    }
    private static void preorderHelper(TreeNode root, List<Integer> list) {
    	if (root == null) return;
    	list.add(root.val);
    	preorderHelper(root.left, list);
    	preorderHelper(root.right, list);
    }
    ***/

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) return list;
		stack.push(root);
		list.add(root.val);
		while (!stack.empty()) {
			root = stack.peek();
			// list.add(root.val);
			if (root.left != null) {
				stack.push(root.left);
				list.add(root.left.val);
				root.left = null;
			} else if (root.right != null) {
				stack.push(root.right);
				list.add(root.right.val);
				root.right = null;
			} else {
				stack.pop();
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