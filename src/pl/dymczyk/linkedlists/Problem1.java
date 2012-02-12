package pl.dymczyk.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {

	public static void removeDuplicated(Node<Integer> node) {
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

	public static void removeDuplicatesNoBuffer(Node<Integer> node) {
		while (node != null) {
			Node<Integer> next = node.getNext();
			Node<Integer> lastUnique = node;
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
		Node<Integer> node = new Node<Integer>(2);
		node.appendToTail(3).appendToTail(2).appendToTail(5);
		node.printList();
		System.out.println();
//		removeDuplicated(node);
		removeDuplicatesNoBuffer(node);
		node.printList();
	}

}