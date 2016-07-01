public class DeleteNode {
	public static void main(String[] args) {
		ListNode temp = new ListNode(1);
		temp.next = new ListNode(2);
		temp.next.next = new ListNode(3);
		temp.next.next.next = new ListNode(4);
		temp.next.next.next.next = null;
		ListNode node = temp.next.next; 
		deleteNode(node);
		while(temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.print("null\n");

	}

	public static void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}
		node.val = node.next.val;
		node.next = node.next.next;
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }

	
}

