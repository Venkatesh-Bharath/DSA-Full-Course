# 1. Understanding the Stack Data Structure

**Explanation:**
- A stack is a linear data structure that follows the Last In, First Out (LIFO) principle.
- Operations typically include:
  - **Push**: Adds an item onto the stack.
  - **Pop**: Removes and returns the most recently added item.
  - **Peek**: Returns the most recently added item without removing it.
  - **isEmpty**: Checks if the stack is empty.

# 2. Applications of Stack

**Explanation:**
- Stacks find applications in various domains such as:
  - Function call management (recursion)
  - Expression evaluation (infix to postfix conversion)
  - Syntax parsing (checking for balanced parentheses)
  - Undo mechanisms in editors
  - Backtracking algorithms

# 3. Implementation of Stack in Array and Linked List

# 4. In C++ (Skipped for Java focus)

# 5. In Java

**Implementation of Stack using Linked List:**

```java
import java.util.EmptyStackException;

class StackLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop() + " popped from stack"); // Output: 3 popped from stack
        System.out.println("Top element is " + stack.peek()); // Output: Top element is 2
    }
}
```

**Explanation:**
- **Node Class**: Represents each element in the stack.
- **push()**: Adds a new node with the given data to the top of the stack.
- **pop()**: Removes and returns the data from the top of the stack.
- **peek()**: Returns the data from the top of the stack without removing it.
- **isEmpty()**: Checks if the stack is empty.

# 6. Problems (With Video Solutions):

# 7. Balanced Parenthesis

**Problem Statement:** Check if a given string of parentheses, brackets, and braces is balanced.

```java
import java.util.*;

public class BalancedParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String testString1 = "{[()]}";
        String testString2 = "{[(])}";

        System.out.println("Test String 1 is balanced: " + isValid(testString1)); // Output: true
        System.out.println("Test String 2 is balanced: " + isValid(testString2)); // Output: false
    }
}
```

# 8. Two Stacks in an Array

**Problem Statement:** Implement two stacks in a single array efficiently.

```java
class TwoStacksInArray {
    private int[] arr;
    private int size;
    private int top1, top2;

    public TwoStacksInArray(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = size;
    }

    public void push1(int x) {
        if (top1 < top2 - 1) {
            arr[++top1] = x;
        } else {
            System.out.println("Stack Overflow for Stack 1");
        }
    }

    public void push2(int x) {
        if (top1 < top2 - 1) {
            arr[--top2] = x;
        } else {
            System.out.println("Stack Overflow for Stack 2");
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        } else {
            System.out.println("Stack Underflow for Stack 1");
            return -1;
        }
    }

    public int pop2() {
        if (top2 < size) {
            return arr[top2++];
        } else {
            System.out.println("Stack Underflow for Stack 2");
            return -1;
        }
    }

    public boolean isEmpty1() {
        return (top1 == -1);
    }

    public boolean isEmpty2() {
        return (top2 == size);
    }

    public static void main(String[] args) {
        TwoStacksInArray ts = new TwoStacksInArray(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);

        System.out.println("Popped element from stack 1: " + ts.pop1()); // Output: 11
        ts.push2(40);
        System.out.println("Popped element from stack 2: " + ts.pop2()); // Output: 40
    }
}
```

# 9. K Stacks in an Array

*Note: Implementing K stacks in an array can be complex and depends heavily on the specific requirements of how the stacks are used and how the array is divided among them. The implementation involves tracking the top elements and managing space allocation dynamically.*

# 10. Stock Span Problem with Variations

*Note: The solution typically involves using a stack to maintain indices of the previous stock prices and calculating the span dynamically.*

# 11. Previous Greater Element

*Note: This problem can be efficiently solved using a stack to keep track of elements in a decreasing order, allowing quick lookup of the nearest greater element.*

# 12. Next Greater Element

*Note: Similar to the previous problem, this can be solved using a stack, but by iterating from right to left and maintaining elements in a decreasing order.*

# 13. Largest Rectangular Area in a Histogram

*Note: This classic problem can be solved using a stack to keep track of indices of histogram bars in a way that allows efficient calculation of the maximum rectangular area.*

# 14. Understanding `getMin()` in Stack with O(1)

*Note: This can be achieved by maintaining an additional stack to keep track of minimum elements as elements are pushed and popped from the main stack.*
