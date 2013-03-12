package pl.dymczyk.stacksandqueues;

public class Problem6 {

  public Stack<Integer> sortStack(Stack<Integer> input) {
    Stack<Integer> buffer = new Stack<Integer>();
    while(!input.isEmpty()) {
      int tmp = buffer.pop();
      while(!buffer.isEmpty() && tmp > buffer.peek()) {
        input.push(buffer.pop());
      }
      buffer.push(tmp);
    }
    return buffer;
  }

}
