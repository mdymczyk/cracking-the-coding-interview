package pl.dymczyk.stacksandqueues;

import pl.dymczyk.linkedlists.Node;

public class Queue<T> {

  private Node<T> first, last;

  public void enqueue(T data) {
    if(first == null) {
      last = new Node<T>(data);
      first = last;
    } else {
      last.setNext(new Node<T>(data));
      last = last.getNext();
    }
  }

  public T dequeue() {
    if(first != null) {
      T data = first.getData();
      first = first.getNext();
      return data;
    }

    return null;
  }

}
