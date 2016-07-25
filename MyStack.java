import java.util.*;
public class MyStack {
	public static void main(String[] args) {
		stack s = new stack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.print(s.top() + "\n");
		s.pop();
		s.pop();
		System.out.print(s.top() + "\n");
		System.out.print(s.empty() + "\n");
		s.pop();
		System.out.print(s.empty() + "\n");	
	}

}
class stack {
	PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
	PriorityQueue<Integer> q2 = new PriorityQueue<Integer>();
	public void push(int x) {
		if (q2.size() == 0) {
			q1.add(x);
		} else {
			q2.add(x);
		}
	}
	public void pop() {
		if (q2.size() == 0) {
			int length = q1.size();
			for (int i = 0; i < length - 1; i++) {
				q2.add(q1.poll());
			}
			q1.poll();
		} else {
			int length = q2.size();
			for (int i = 0; i < length - 1; i++) {
				q1.add(q2.poll());
			}
			q2.poll();
		}
	}
	public int top() {
		int val = -1;
		if (q2.size() == 0) {
			int length = q1.size();
			for (int i = 0; i < length; i++) {
				val = q1.peek();
				q2.add(q1.poll());
			}
			
		} else {
			int length = q2.size();
			for (int i = 0; i < length; i++) {
				val = q2.peek();
				q1.add(q2.poll());
			}
			
		}	
		return val;
	}
	public boolean empty() {
		return q1.size() == 0 && q2.size() == 0;
	}
}