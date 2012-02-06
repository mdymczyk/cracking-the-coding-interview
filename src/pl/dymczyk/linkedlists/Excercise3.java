package pl.dymczyk.linkedlists;

public class Excercise3 {

	public static void main(String[] args) {
		LinkedListNode<Integer> node = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> toDelete = node.appendToTail(3).appendToTail(2);
		toDelete.appendToTail(5).appendToTail(7).appendToTail(9).appendToTail(4);
		node.printList();
		
		System.out.println();
		
		delete(toDelete);
		
		node.printList();
		
	}

	private static void delete(LinkedListNode<Integer> toDelete) {
		if(toDelete == null || toDelete.getNext() == null) {
			return;
		}
		
		toDelete.setData(toDelete.getNext().getData());
		toDelete.setNext(toDelete.getNext().getNext());
	}
	
}
