package pl.dymczyk.linkedlists;

public class Excercise5 {

	public static void main(String[] args) {
		LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(7);
		node1.appendToTail(1).appendToTail(6);
		node1.printList();
		LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(5);
		node2.appendToTail(9);
		node2.printList();
		addTwoNumbers(node1, node2).printList();
		addNumbersRecursive(node1, node2, 0).printList();
	}

	/*********************************************************
	 * Recursive solution. Shorter but more memory consuming.*
	 *********************************************************/
	
	private static LinkedListNode<Integer> addNumbersRecursive(
			LinkedListNode<Integer> one, LinkedListNode<Integer> two, int carry) {
		if (one == null && two == null && carry == 0) {
			return null;
		}

		int sum = carry;
		if (one != null) {
			sum += one.getData();
		}

		if (two != null) {
			sum += two.getData();
		}

		LinkedListNode<Integer> node = new LinkedListNode<Integer>(sum % 10);

		if (one != null || two != null || sum > 9) {
			node.setNext(addNumbersRecursive(
					one != null ? one.getNext() : null,
					two != null ? two.getNext() : null, sum > 9 ? 1 : 0));
		}

		return node;
	}

	/*********************************************************
	 * Iterative. Much longer but less memory consuming.     *
	 *********************************************************/
	
	private static LinkedListNode<Integer> addTwoNumbers(
			LinkedListNode<Integer> one, LinkedListNode<Integer> two) {
		LinkedListNode<Integer> head = new LinkedListNode<Integer>(0);
		LinkedListNode<Integer> result = head;

		while (one != null || two != null) {
			int sum = addValues(one, two);
			LinkedListNode<Integer> nextResult;
			if (sum < 10) {
				boolean isLast = isLast(one, two);
				nextResult = nextResult(result, sum, 0, isLast);
			} else {
				nextResult = nextResult(result, sum % 10, 1, false);
			}
			result.setNext(nextResult);
			result = nextResult;

			one = getNext(one);
			two = getNext(two);
		}

		return head;
	}

	private static boolean isLast(LinkedListNode<Integer> one,
			LinkedListNode<Integer> two) {
		if ((one != null && one.getNext() != null)
				|| (two != null && two.getNext() != null)) {
			return false;
		}
		return true;
	}

	private static LinkedListNode<Integer> nextResult(
			LinkedListNode<Integer> result, int sum, int i, boolean isLast) {
		result.setData(result.getData() + sum);

		if (isLast) {
			return null;
		}

		return new LinkedListNode<Integer>(i);
	}

	private static LinkedListNode<Integer> getNext(LinkedListNode<Integer> node) {
		if (node != null) {
			return node.getNext();
		}
		return null;
	}

	private static int addValues(LinkedListNode<Integer> one,
			LinkedListNode<Integer> two) {
		if (one == null) {
			return two.getData();
		} else if (two == null) {
			return one.getData();
		}

		return one.getData() + two.getData();
	}

}
