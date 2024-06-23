# 1. Introduction and Application

**Explanation:**
- A queue is a linear data structure that follows the First In, First Out (FIFO) principle.
- Common applications include:
  - Managing tasks in a printer queue.
  - Handling requests in web servers.
  - Breadth-First Search (BFS) in graph traversal.

# 2. Implementation of Queue using Array and LinkedList

**2.1 Queue using Array:**

```java
class QueueArray {
    private int[] arr;
    private int front, rear, size, capacity;
    
    public QueueArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return arr[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println(queue.dequeue() + " dequeued from queue"); // Output: 1 dequeued from queue
        System.out.println("Front element is " + queue.peek()); // Output: Front element is 2
    }
}
```

**2.2 Queue using LinkedList:**

```java
class QueueLinkedList {
    private static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node front, rear;
    
    public QueueLinkedList() {
        front = rear = null;
    }
    
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return front.data;
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println(queue.dequeue() + " dequeued from queue"); // Output: 1 dequeued from queue
        System.out.println("Front element is " + queue.peek()); // Output: Front element is 2
    }
}
```

# 3. In C++ STL (Skipped for Java focus)

# 4. In Java (Already covered above)

# 5. Stack using Queue

```java
import java.util.*;

class StackUsingQueue {
    private Queue<Integer> queue;
    
    public StackUsingQueue() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.remove();
    }
    
    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.peek();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println(stack.pop() + " popped from stack"); // Output: 3 popped from stack
        System.out.println("Top element is " + stack.top()); // Output: Top element is 2
    }
}
```

# 6. Problems (With Video Solutions)

# 7. Reversing a Queue

```java
import java.util.*;

class ReverseQueue {
    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        
        System.out.println("Original Queue: " + queue); // Output: Original Queue: [1, 2, 3]
        reverse(queue);
        System.out.println("Reversed Queue: " + queue); // Output: Reversed Queue: [3, 2, 1]
    }
}
```

# 8. Generate Numbers with Given Digits

*Note: Generating numbers with given digits can be approached using BFS or DFS, depending on the problem requirements.*

# 9. Maximums of All Subarrays of Size k

*Note: This problem involves sliding window techniques and can be efficiently solved using a deque (double-ended queue) for optimal performance.*
