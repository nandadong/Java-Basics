import java.util.*;
public class LinkedListIntersection {
	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(2);
		headA.next.next = new ListNode(3);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);

		ListNode headB = new ListNode(6);
		// headB.next = new ListNode(7);
		// headB.next.next = new ListNode(8);
		// headB.next.next.next = headA.next.next;

		ListNode intersection = getIntersectionNode(headA, headB);
		if (intersection == null) {
			System.out.print("No intersection\n");
		} else {
			System.out.print(intersection.val + "\n");
		}
	}
	// public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	// 	HashSet<ListNode> set = new HashSet<ListNode>();
	// 	while (headA != null) {
	// 		set.add(headA);
	// 		headA = headA.next;
	// 	}
	// 	while (headB != null) {
	// 		if (set.contains(headB)) {
	// 			return headB;
	// 		}
	// 		headB = headB.next;
	// 	}
	// 	return null;
	// }
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode pA = headA;
		ListNode pB = headB;
		ListNode tailA = null, tailB = null;
		while (pA != null && pB != null) {
			if (pA == pB) {
				return pA;
			}
			if (pA.next == null) {
				tailA = pA;
				pA = headB;
				if (tailB != null && tailB != tailA) {
					break;
				}
			} else {
				pA = pA.next;	
			}
			if (pB.next == null) {
				tailB = pB;
				pB = headA;
				if (tailA != null && tailA != tailB) {
					break;
				}
			} else {
				pB = pB.next;
			}
		}
		return null;
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