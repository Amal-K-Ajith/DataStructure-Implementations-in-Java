/**
 * A basic implementation of Double Linked List using Node which is a class
 */
public class MyDoubleLinkedList<T> {

	Node head, tail;
	private int count;

	public void add(T d) {
		if (head == null) {
			head = new Node(null, d, null);
			count++;
			return;
		}
		Node cur = head;
		while (cur.next != null)
			cur = cur.next;
		cur.next = new Node(cur, d, null);
		tail = cur.next;
		count++;
	}

	public T get(int index) {
		if(index<0 || index>=count)return null;
		if(index==0)return head.data;
		Node cur=head;
		for(int i=1;i<index;i++)cur=cur.next;
		return cur.data;
	}

	public void addFirst(T d) {
		if (head == null) {
			head = new Node(null, d, null);
			count++;
			return;
		}
		Node cur = head;
		head = new Node(null, d, cur);
		cur.prev = head;
		count++;
	}

	@Override
	public String toString() {
		String m = "[" + head.data;
		Node cur = head.next;
		for (int i = 1; i < count; i++) {
			m += ", " + cur.data;
			cur = cur.next;
		}
		return m + "]";
	}

	public String reverseOrder() {
		String m = "[" + tail.data;
		Node cur = tail.prev;
		for (int i = 1; i < count; i++) {
			m += ", " + cur.data;
			cur = cur.prev;
		}
		return m + "]";
	}

	public int size() {
		return count;
	}
	
	public void clear() {
		head=null;
		count=0;
	}
	// Class Node
	class Node {
		T data;
		Node prev, next;

		Node(Node p, T d, Node n) {
			prev = p;
			data = d;
			next = n;
		}
	}
}
