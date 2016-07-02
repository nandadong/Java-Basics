public class ReverseList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = null;
		ListNode reverse = reverseList(head);
		while(reverse != null) {
			System.out.print(reverse.val + "->");
			reverse = reverse.next;
		}
		System.out.print("null\n");
	}
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode result = new ListNode(head.val);
		result.next = null;
		while(head.next != null) {
			ListNode temp = new ListNode(head.next.val);
			temp.next = result;
			result = temp;
			head = head.next;
		}
		return result;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}