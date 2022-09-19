public class MyStack<T> {

	private Node first;
	private int count;

	public void push(T e) {
		if (first == null) {
			first = new Node(e, null);
			count++;
			return;
		}
		Node prev = first;
		first = new Node(e, prev);
		count++;
	}

	public int size() {
		return count;
	}

	public T peek() {
		return first.ele;
	}

	@Override
	public String toString() {
		if (first == null)
			return "[]";
		String a = "[" + first.ele;
		Node cur = first.next;
		for (int i = 1; i < count; i++) {
			a += ", " + cur.ele;
			cur = cur.next;
		}
		return a + "]";
	}

	public T pop() {
		if (first == null)
			throw new NullPointerException();
		T r = first.ele;
		first = first.next;
		count--;
		return r;
	}

	public boolean isEmpty() {
		if (first == null)
			return true;
		return false;
	}

	private class Node {
		T ele;
		Node next;

		Node(T e, Node n) {
			ele = e;
			next = n;
		}
	}
}