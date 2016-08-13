import java.util.*;
public class RandomNode {
	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(1);
		head.next.next = new ListNode(10);
		head.next.next.next = new ListNode(20);
		head.next.next.next.next = new ListNode(100);
		Solution solution = new Solution(head);

		System.out.println(solution.getRandom());
	}
}

class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    Random random;
    int length = 0;
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
        ListNode p = head;
        while (p != null) {
        	length ++;
        	p = p.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int n = random.nextInt(length);
        ListNode p = head;
        for (int i = 0; i < n; i++) {
        	p = p.next;
        }
        return p.val;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */