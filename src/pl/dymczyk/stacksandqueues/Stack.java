package pl.dymczyk.stacksandqueues;

import pl.dymczyk.linkedlists.Node;

public class Stack<T> {

  private Node<T> top;
  private int size = 0;

  public T pop() {
    if (top != null) {
      T popped = top.getData();
      top = top.getNext();
      size--;
      return popped;
    }

    return null;
  }

  public void push(T data) {
    Node<T> newTop = new Node<T>(data);
    newTop.setNext(top);
    top = newTop;
    size++;
  }

  public boolean isEmpty() {
    return top != null;
  }

  public T peek() {
    if (top != null) {
      return top.getData();
    }

    return null;
  }

  public int size() {
    return size;
  }
}
