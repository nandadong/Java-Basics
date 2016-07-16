import java.util.*;
public class MergeList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(3);

		ListNode merge = mergeTwoLists(l1, l2);
		while (merge != null) {
			System.out.print(merge.val + " ");
			merge = merge.next;
		}
		System.out.print("\n");
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode fakehead = new ListNode(-1);
		ListNode node = fakehead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				node = node.next;
				l1 = l1.next;
			} else {
				node.next = l2;
				node = node.next;
				l2 = l2.next;
			}

		}
		if (l1 != null) {
			node.next = l1;
		} else {
			node.next = l2;
		}
		return fakehead.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}