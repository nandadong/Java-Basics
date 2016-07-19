import java.util.*;
public class MyQueue {
	public static void main(String[] args) {
		queue q = new queue();
		q.push(1);
		q.push(2);
		q.push(3);
		System.out.print(q.peek() + "\n");
		q.pop();
		q.pop();
		System.out.print(q.peek() + "\n");
	}

}

class queue {
	Stack<Integer> st1 = new Stack<Integer>();
	Stack<Integer> st2 = new Stack<Integer>();
	public void push(int x) {
		while (!st2.empty()) {
			st1.push(st2.pop());
		}
		st1.push(new Integer(x));
	}
	public void pop() {
		while (!st1.empty()) {
			st2.push(st1.pop());
		}
		st2.pop();
	}
	public int peek() {
		while (!st1.empty()) {
			st2.push(st1.pop());
		}
		return (int)st2.peek();
	}
	public boolean empty() {
		return st1.empty() && st2.empty();
	}
}