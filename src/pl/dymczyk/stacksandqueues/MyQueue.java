package pl.dymczyk.stacksandqueues;

// Problem 3.5

public class MyQueue<T> {

  private Stack<T> first;
  private Stack<T> second;

  public void enqueue(T data) {
    if(first.isEmpty()) {
      swap(first, second);
    }
    first.push(data);
  }

  public T dequeue() {
    if(second.isEmpty()) {
      swap(second, first);
    }
    return second.pop();
  }

  private void swap(Stack<T> from, Stack<T> to) {
    while(!from.isEmpty()) {
      to.push(from.pop());
    }
  }

}
