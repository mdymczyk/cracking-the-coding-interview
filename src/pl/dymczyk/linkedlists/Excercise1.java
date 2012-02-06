package pl.dymczyk.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class Excercise1 {

	public static void removeDuplicated(LinkedListNode<Integer> node) {
		Set<Integer> uniqueValues = new HashSet<Integer>();

		if (node == null) {
			return;
		}

		uniqueValues.add(node.getData());

		while (node.getNext() != null) {
			if (uniqueValues.contains(node.getNext().getData())) {
				node.setNext(node.getNext().getNext());
			} else {
				uniqueValues.add(node.getData());
			}
			node = node.getNext();
		}
	}

	public static void removeDuplicatesNoBuffer(LinkedListNode<Integer> node) {
		while (node != null) {
			LinkedListNode<Integer> next = node.getNext();
			LinkedListNode<Integer> lastUnique = node;
			while (next != null) {
				if (node.getData().equals(next.getData())) {
					lastUnique.setNext(next.getNext());
				}
				lastUnique = next;
				next = next.getNext();
			}
			node = node.getNext();
		}
	}

	public static void main(String[] args) {
		LinkedListNode<Integer> node = new LinkedListNode<Integer>(2);
		node.appendToTail(3).appendToTail(2).appendToTail(5);
		node.printList();
		System.out.println();
//		removeDuplicated(node);
		removeDuplicatesNoBuffer(node);
		node.printList();
	}

}