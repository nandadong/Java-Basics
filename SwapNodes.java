public class SwapNodes {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		ListNode swap = swapPairs(head);
		while (swap != null) {
			System.out.print(swap.val);
			if (swap.next != null) {
				System.out.print("->");
			}
			swap = swap.next;
		}
		System.out.print("\n");
	}
	public static ListNode swapPairs(ListNode head) {
		ListNode fakehead = new ListNode(-1), temp;
		fakehead.next = head;
		head = fakehead;
		while (fakehead.next != null && fakehead.next.next != null) {
			temp = fakehead.next.next;
			fakehead.next.next = temp.next;
			temp.next = fakehead.next;
			fakehead.next = temp;
			fakehead = temp.next;
		}
		return head.next;
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}