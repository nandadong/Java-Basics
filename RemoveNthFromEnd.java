public class RemoveNthFromEnd {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		int n = 5;
		head = removeNthFromEnd(head, n);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.print("\n");
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int length = 0;
		ListNode dummyhead = new ListNode(0);
		dummyhead.next = head;
		ListNode p = head;
		while (p != null) {
			length ++;
			p = p.next;
		}
		p = dummyhead;
		for (int i = 0; i < length - n; i++) {
			p = p.next;
		}
		p.next = p.next.next;
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