package pl.dymczyk.stacksandqueues;

import java.util.EmptyStackException;

public class Problem1<T> {

  private static int STACK_SIZE = 300;
  private T[] stacks = (T[]) new Object[3* STACK_SIZE];
  private int stackPointer[] = {-1,-1,-1};

  public void push(T data, int stackNumber) {
    int arrayStackNumber = stackNumber-1;
    int currentIndex = arrayStackNumber*STACK_SIZE + stackPointer[arrayStackNumber] + 1;
    if(currentIndex >= stackNumber*STACK_SIZE) {
      throw new StackOverflowError();
    }
    stacks[currentIndex] = data;
    stackPointer[arrayStackNumber]++;
  }

  public T pop(int stackNumber) {
    int arrayStackNumber = stackNumber-1;
    int currentIndex = arrayStackNumber*STACK_SIZE + stackPointer[arrayStackNumber];

    if(currentIndex < arrayStackNumber*STACK_SIZE) {
      throw new EmptyStackException();
    }
    T data = stacks[currentIndex];
    stacks[currentIndex] = null;
    stackPointer[arrayStackNumber]--;
    return data;
  }

  public T peek(int stackNumber) {
    int arrayStackNumber = stackNumber-1;
    int currentIndex = arrayStackNumber*STACK_SIZE + stackPointer[arrayStackNumber];
    if(currentIndex < arrayStackNumber*STACK_SIZE) {
      throw new EmptyStackException();
    }
    return stacks[currentIndex];
  }

  public boolean isEmpty(int stackNumber) {
    return stackPointer[stackNumber - 1] < (stackNumber-1)*STACK_SIZE;
  }

  // The second approach would be to start form 0 and insert elements up to array_size
  // and simply store the data and the position of the previous element of this stack
  // probably would need some tuning and more thinking...

  public static void main(String[] sargs) {

  }

}
