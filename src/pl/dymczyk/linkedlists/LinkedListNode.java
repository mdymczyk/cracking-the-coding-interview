package pl.dymczyk.linkedlists;

public class LinkedListNode<T> {

	private LinkedListNode<T> next;
	private T data;
	
	public LinkedListNode(T data) {
		this.data = data;
	}

	public LinkedListNode<T> appendToTail(T data) {
		LinkedListNode<T> tail = new LinkedListNode<T>(data);
		LinkedListNode<T> node = this;
		while(node.getNext() != null) {
			node = node.getNext();
		}
		node.next = tail;
		return tail;
	}
	
	public void printList() {
		LinkedListNode<T> node = this;
		while (node != null) {
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
		System.out.println();
	}
	
	public LinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
}
