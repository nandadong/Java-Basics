public class RemoveDuplicate {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(3);

		head = deleteDuplicates(head);
		while (head != null) {
			System.out.print(head.val + "\n");
			head = head.next;
		}
	}
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummyhead = head;
		while (head != null && head.next != null) {
			while (head.val == head.next.val) {
				head.next = head.next.next;
				if (head.next == null) {
					break;
				}
			}
			head = head.next;
		}
		return dummyhead;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}