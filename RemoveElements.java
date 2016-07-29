public class RemoveElements {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		int val = 1;
		head = removeElements(head, val);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.print("\n");
	}
	public static ListNode removeElements(ListNode head, int val) {
		ListNode dummyhead = new ListNode(-1);
		dummyhead.next = head;
		ListNode temp = dummyhead;
		while (temp.next != null) {
			if (temp.next.val == val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return dummyhead.next;
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}