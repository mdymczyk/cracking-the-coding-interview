package pl.dymczyk.stacksandqueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class Problem3 {

}

class SetOfStacks<T> {

  private int threshold = 1;
  LinkedList<Stack<T>> stacks = new LinkedList<Stack<T>>();

  public SetOfStacks(int threshold) {
    this.threshold = threshold;
  }

  public void push(T data) {
    Stack<T> last = stacks.getLast();
    if(last != null && atCapacity(last)) {
      last.push(data);
    } else {
      Stack<T> newStack = new Stack<T>();
      newStack.push(data);
      stacks.push(newStack);
    }
  }

  public T pop() {
    Stack<T> last = stacks.getLast();

    if(last == null) {
      throw new EmptyStackException();
    }

    T data = last.pop();
    if(last.isEmpty()) {
      stacks.pop();
    }

    return data;
  }

  public T popAt(int i) {
    // this would remove a lot of coding but in general I guess we need to
    // implement some kind of mechanism which would tak the last element of stack i+1
    // and push it on top of stack i
    return null;
  }

  // This might/should be implemented in the Stack class
  private boolean atCapacity(Stack<T> stack) {
    return stack.size() == threshold;
  }
}