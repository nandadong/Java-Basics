public class OddEvenList {
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
    	head = oddEvenList(head);
    	while (head != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    	System.out.print("\n");
    }
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, even_head = even;
        while (even != null && even.next != null) {
        	odd.next = even.next;
        	even.next = even.next.next;
        	odd = odd.next;
        	even = even.next;
        }
        odd.next = even_head;
        return head;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}