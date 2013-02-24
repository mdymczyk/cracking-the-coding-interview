package pl.dymczyk.linkedlists;



public class Problem7 {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(2);
		node.appendToTail(3).appendToTail(2).appendToTail(5);
		node.printList();
		System.out.println();
		node.printList();
	}

	// 1 2 3 2 1
	// 1 2 2 1
	
//	public static <T> boolean isPalindrome(Node<T> head) {
//		int listSize = getListSize(head);
//		Node<T> node = getFirstNodeAfterMiddle(head, listSize);
//		
//	}
	
	private static <T> Node<T> getFirstNodeAfterMiddle(Node<T> head, int size) {
		Node<T> result = head;
		for(int i = 0; i < (int) Math.ceil(size / 2); i++) {
			result = result.getNext();
		}
		return result;
	}
		
	private static <T> int getListSize(Node<T> head) {
		int size = 0;
		
		while(head != null) {
			size++;
			head = head.getNext();
		}
		
		return size;
	}
}