package pl.dymczyk.stacksandqueues;

import com.sun.deploy.config.Config;
import pl.dymczyk.linkedlists.Node;

public class Problem2 {
  MinStack<Integer> test = new MinStack<Integer>();
}

class MinStack<T extends Integer> extends Stack<NodeWithMin> {

  public void push(T data) {
    int min = Math.min(data.intValue(), currentMin());
    super.push(new NodeWithMin(min, data.intValue()));
  }

  private int currentMin() {
    if(this.isEmpty()) {
      return java.lang.Integer.MIN_VALUE;
    } else {
      return peek().min;
    }
  }
}

// A bit waste of space - a lot of nodes might store the same value
// Might be a better option to store a separate stack with minimums and pop it when we pop the current minimum
// But this requires a new stack.


class NodeWithMin {
  public int min;
  public int data;

  public NodeWithMin(int min, int data) {
    this.min = min;
    this.data = data;
  }
}