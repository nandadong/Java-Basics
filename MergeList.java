import java.util.*;
public class MergeList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		// l1.next = new ListNode(2);
		// l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(1);
		// l2.next = new ListNode(5);

		ListNode merge = mergeTwoLists(l1, l2);
		while (merge != null) {
			System.out.print(merge.val + " ");
			merge = merge.next;
		}
		System.out.print("\n");
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode merge = l1;
		while (l1 != null) {
			ListNode l2head = l2;
			while (l2 != null) {
				if (l1.next != null && l2.val >= l1.val && l2.val <= l1.next.val) {
					ListNode temp = new ListNode(l2.val);
					temp.next = l1.next;
					l1.next = temp;
					l1 = temp;
					l2 = l2.next;
					continue;
				} else if (l1.next == null && l2.val >= l1.val) {
					ListNode temp = new ListNode(l2.val);
					temp.next = null;
					l1.next = temp;
					l1 = l1.next;
					l2 = l2.next;
					continue;
				} else if (l2.val <= l1.val) {
					ListNode temp = new ListNode(l2.val);
					temp.next = l1;
					l1 = temp;
					merge = l1;
					l2 = l2.next;
					continue;
				}
				l2 = l2.next;
			}
			// l2 = l2head;
			l1 = l1.next;
		}
		return merge;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}