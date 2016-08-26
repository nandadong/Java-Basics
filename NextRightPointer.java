import java.util.*;
public class NextRightPointer {
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		connect(root);
		System.out.println(root.left.next.val);
		System.out.println(root.left.left.next.val);
		System.out.println(root.left.right.next.val);
		System.out.println(root.right.left.next.val);
	}
	public static void connect(TreeLinkNode root) {
		TreeLinkNode start = root;
		while (start != null) {
			TreeLinkNode current = start;
			while (current != null) {
				if (current.left != null) current.left.next = current.right;
				if (current.right != null && current.next != null) current.right.next = current.next.left;
				current = current.next;
			}
			start = start.left;
		}
	}
	
}
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}

/*
	if (root.left != null)
		root.left.next = root.right;
*/