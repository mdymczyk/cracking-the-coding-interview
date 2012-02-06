package pl.dymczyk.linkedlists;

public class Excercise4 {

	public static void main(String[] args) {
		LinkedListNode<Integer> node = new LinkedListNode<Integer>(1);
		node.appendToTail(3).appendToTail(7).appendToTail(5).appendToTail(2)
				.appendToTail(9).appendToTail(4);
		node.printList();
		partitionList(node, 5).printList();
		partitionList2(node, 5).printList();
	}

	private static LinkedListNode<Integer> partitionList2(LinkedListNode<Integer> node, int x) {
		LinkedListNode<Integer> pivot = null;
		LinkedListNode<Integer> before = null;
		LinkedListNode<Integer> after = null;
		
		while (node != null) {
			LinkedListNode<Integer> next = node.getNext();
			
			if(node.getData() < x) {
				node.setNext(before);
				before = node;
			} else if (node.getData() > x) {
				node.setNext(after);
				after = node;
			} else {
				pivot = node;
			}
			
			node = next;
		}

		if(before == null) {
			return after;
		}
		
		LinkedListNode<Integer> head = before;
		while(before.getNext() != null) {
			before = before.getNext();
		}

		pivot.setNext(after);
		before.setNext(pivot);
		
		return head;
	}
	
	private static LinkedListNode<Integer> partitionList(LinkedListNode<Integer> node, int x) {
		LinkedListNode<Integer> partitionNode = null;

		LinkedListNode<Integer> beforeStart = null;
		LinkedListNode<Integer> beforeEnd = null;
		
		LinkedListNode<Integer> afterStart = null;
		LinkedListNode<Integer> afterEnd = null;
		
		while (node != null) {
			LinkedListNode<Integer> next = node.getNext();
			node.setNext(null);
			if(node.getData() < x) {
				if(beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.setNext(node);
					beforeEnd = node;
				}
			} else if(node.getData() > x) {
				if(afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.setNext(node);
					afterEnd = node;
				}
			} else {
				// only one node with value "x" supported
				// change this to a new list to support multiple nodes with value "x"
				partitionNode = node;
			}
			node = next;
		}
		
		if(beforeStart == null) {
			return afterStart;
		}
		
		partitionNode.setNext(afterStart);
		beforeEnd.setNext(partitionNode);
		
		return beforeStart;
	}

}
