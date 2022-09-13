/**
 * A basic implementation of LinkedList using Node which is a class
 */
public class MyLinkedList <T> /*----Generic Type----*/{
	private Node first;
	private int count;

	public void clear() {
		this.first = null;
		this.count = 0;
	}

	public void add(T e) {
		if (first == null) {
			first = new Node(e, null);
			count++;
			return;
		}
		Node cur = first;
		while (cur.next != null)
			cur = cur.next;
		cur.next = new Node(e, null);
		count++;
	}

	public void remove(int index) {
		if (index >= count || index < 0)
			throw new IndexOutOfBoundsException();
		if (index == 0) {
			first = first.next;
			count--;
			return;
		}
		Node cur = first;
		for (int i = 1; i < index; i++) {
			cur = cur.next;
		}
		cur.next = cur.next.next;
		count--;
	}

	public T get(int index) {
		if(index<0 || index>=count)return null;
		if(index==0)return first.ele;
		Node cur=first.next;
		for(int i=1;i<index;i++)
			cur=cur.next;
		return cur.ele;
		
	}

	public void insert(T data,int index) {
		if(index<0 || index>=count)throw new IndexOutOfBoundsException();
		Node cur;
		if(index==0){
			cur=first;
			first=new Node(data, cur);
			return;
		}
		cur=first;
		for(int i=1;i<index;i++){
			cur=cur.next;
		}
		Node n=new Node(data, cur.next);
		cur.next=n;
		this.count++;
	}

	public int size() {
		return count;
	}

	@Override
	public String toString() {
		if (this.first == null)
			return null;
		StringBuilder a = new StringBuilder("[" + first.ele);
		Node cur = first.next;
		for (int i = 1; i < count; i++) {
			a.append(", " + cur.ele);
			cur = cur.next;
		}
		return a.toString() + "]";
	}

	// Class Node
	private class Node {
		T ele;
		Node next;
		Node(T e, Node n) {
			ele = e;
			next = n;
		}
	}
}
