# Module 11: Linked List

# 1. Introduction
A linked list is a linear data structure where each element is a separate object called a node. Each node contains data and a reference (or link) to the next node in the sequence. Linked lists allow for efficient insertion and deletion of elements.

# 3. Implementation in Java
```java
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    
    // Method to insert a new node at the end
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }
    
    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.printList(); // Output: 1 2 3
    }
}
```

# 4. Comparison with Array DS
- **Memory Allocation**: Linked lists use dynamic memory allocation while arrays use static memory allocation.
- **Access Time**: Arrays provide O(1) access time while linked lists have O(n) access time for accessing elements.
- **Insertion/Deletion**: Linked lists allow O(1) insertion/deletion if the reference to the node is known, whereas arrays require O(n) for the same operations.

# 5. Doubly Linked List
A doubly linked list is a type of linked list where each node has two references: one to the next node and one to the previous node.

```java
class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;
    
    DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    DoublyNode head;
    
    // Method to insert a new node at the end
    public void append(int data) {
        if (head == null) {
            head = new DoublyNode(data);
            return;
        }
        DoublyNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        DoublyNode newNode = new DoublyNode(data);
        current.next = newNode;
        newNode.prev = current;
    }
    
    // Method to print the doubly linked list
    public void printList() {
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.printList(); // Output: 1 2 3
    }
}
```

# 6. Circular Linked List
A circular linked list is a type of linked list where the last node points back to the head of the list.

```java
class CircularNode {
    int data;
    CircularNode next;
    
    CircularNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    CircularNode head;
    
    // Method to insert a new node at the end
    public void append(int data) {
        if (head == null) {
            head = new CircularNode(data);
            head.next = head;
            return;
        }
        CircularNode current = head;
        while (current.next != head) {
            current = current.next;
        }
        CircularNode newNode = new CircularNode(data);
        current.next = newNode;
        newNode.next = head;
    }
    
    // Method to print the circular linked list
    public void printList() {
        if (head == null) {
            return;
        }
        CircularNode current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
    
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.printList(); // Output: 1 2 3
    }
}
```

# 7. Loop Problems
Loop problems in linked lists occur when a sequence of nodes forms a loop. This can cause issues such as infinite traversal.

# 8. Detecting Loops
To detect loops in a linked list, you can use Floyd's Cycle-Finding Algorithm, also known as the Tortoise and Hare algorithm.

# 9. Detecting loops using Floyd cycle detection
```java
class DetectLoop {
    Node head;
    
    public boolean hasLoop() {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        DetectLoop list = new DetectLoop();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = list.head; // Creating a loop
        System.out.println("Loop detected: " + list.hasLoop()); // Output: Loop detected: true
    }
}
```

# 10. Detecting and Removing Loops in Linked List
```java
class DetectAndRemoveLoop {
    Node head;
    
    public boolean detectAndRemoveLoop() {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(slow);
                return true;
            }
        }
        return false;
    }
    
    private void removeLoop(Node loopNode) {
        Node ptr1 = head;
        Node ptr2;
        while (true) {
            ptr2 = loopNode;
            while (ptr2.next != loopNode && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
            if (ptr2.next == ptr1) {
                break;
            }
            ptr1 = ptr1.next;
        }
        ptr2.next = null;
    }
    
    public static void main(String[] args) {
        DetectAndRemoveLoop list = new DetectAndRemoveLoop();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = list.head; // Creating a loop
        list.detectAndRemoveLoop();
        System.out.println("Loop detected and removed");
    }
}
```

# 11. Problems(With Video Solutions):

# 12. Middle of Linked List
```java
class MiddleOfLinkedList {
    Node head;
    
    public Node findMiddle() {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        MiddleOfLinkedList list = new MiddleOfLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        Node middle = list.findMiddle();
        System.out.println("Middle of linked list: " + (middle != null ? middle.data : "List is empty")); // Output: 3
    }
}
```

# 13. Nth node from the end of linked list
```java
class NthNodeFromEnd {
    Node head;
    
    public Node findNthFromEnd(int n) {
        if (head == null) {
            return null;
        }
        Node first = head;
        Node second = head;
        for (int i = 0; i < n; i++) {
            if (first == null) {
                return null; // N is larger than the number of nodes in the list
            }
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
    
    public static void main(String[] args) {
        NthNodeFromEnd list = new NthNodeFromEnd();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
       

 list.head.next.next.next.next = new Node(5);
        Node nthNode = list.findNthFromEnd(2);
        System.out.println("Nth node from the end: " + (nthNode != null ? nthNode.data : "List is too short")); // Output: 4
    }
}
```

# 14. Deleting a Node without accessing Head pointer of Linked List
```java
class DeleteNodeWithoutHead {
    Node head;
    
    public void deleteNode(Node node) {
        if (node == null || node.next == null) {
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
    
    public static void main(String[] args) {
        DeleteNodeWithoutHead list = new DeleteNodeWithoutHead();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.deleteNode(list.head.next.next); // Deleting node with value 3
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
```

# 15. An iterative method to Reverse a linked list
```java
class ReverseLinkedListIterative {
    Node head;
    
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    public static void main(String[] args) {
        ReverseLinkedListIterative list = new ReverseLinkedListIterative();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.reverse();
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
```

# 16. Recursive method to reverse a linked list
```java
class ReverseLinkedListRecursive {
    Node head;
    
    public Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node rest = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }
    
    public static void main(String[] args) {
        ReverseLinkedListRecursive list = new ReverseLinkedListRecursive();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head = list.reverse(list.head);
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
```

# 17. Segregating even-odd nodes of linked list
```java
class SegregateEvenOdd {
    Node head;
    
    public void segregate() {
        Node end = head;
        Node prev = null;
        Node curr = head;
        
        while (end.next != null) {
            end = end.next;
        }
        Node newEnd = end;
        
        while (curr != null && curr.data % 2 != 0) {
            newEnd.next = curr;
            curr = curr.next;
            newEnd.next.next = null;
            newEnd = newEnd.next;
        }
        
        if (curr == null) {
            return;
        }
        
        head = curr;
        
        while (curr != end) {
            if (curr.data % 2 == 0) {
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
                curr = curr.next;
            } else {
                if (prev != null) {
                    prev.next = curr.next;
                }
                newEnd.next = curr;
                newEnd = curr;
                curr = curr.next;
                newEnd.next = null;
            }
        }
        
        if (end.data % 2 == 0) {
            if (prev != null) {
                prev.next = end;
            }
        } else {
            newEnd.next = end;
            if (prev != null) {
                prev.next = end.next;
            }
            end.next = null;
        }
    }
    
    public static void main(String[] args) {
        SegregateEvenOdd list = new SegregateEvenOdd();
        list.head = new Node(17);
        list.head.next = new Node(15);
        list.head.next.next = new Node(8);
        list.head.next.next.next = new Node(12);
        list.head.next.next.next.next = new Node(10);
        list.head.next.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next.next = new Node(4);
        list.segregate();
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
```

# 18. The intersection of two linked list
```java
class IntersectionOfLinkedLists {
    Node head1, head2;
    
    public Node getIntersectionNode() {
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        
        Node longer = length1 > length2 ? head1 : head2;
        Node shorter = length1 > length2 ? head2 : head1;
        
        int difference = Math.abs(length1 - length2);
        
        while (difference > 0) {
            longer = longer.next;
            difference--;
        }
        
        while (longer != null && shorter != null) {
            if (longer == shorter) {
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        
        return null;
    }
    
    private int getLength(Node node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
    
    public static void main(String[] args) {
        IntersectionOfLinkedLists list = new IntersectionOfLinkedLists();
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);
        
        list.head2 = new Node(10);
        list.head2.next = list.head1.next.next.next; // 15
        
        Node intersection = list.getIntersectionNode();
        System.out.println("Intersection point: " + (intersection != null ? intersection.data : "No intersection"));
    }
}
```

# 19. Pairwise swap nodes of linked list
```java
class PairwiseSwap {
    Node head;
    
    public void pairwiseSwap() {
        Node temp = head;
        
        while (temp != null && temp.next != null) {
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
    }
    
    public static void main(String[] args) {
        PairwiseSwap list = new PairwiseSwap();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.pairwiseSwap();
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
```

# 20. Clone a linked list using a random pointer
```java
class RandomNode {
    int data;
    RandomNode next, random;
    
    RandomNode(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

class CloneLinkedList {
    RandomNode head;
    
    public RandomNode clone() {
        if (head == null) {
            return null;
        }
        
        RandomNode current = head;
        while (current != null) {
            RandomNode newNode = new RandomNode(current.data);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        
        current = head;
        while (current != null) {
            if (current.next != null) {
                current.next.random = (current.random != null) ? current.random.next : current.random;
            }
            current = current.next.next;
        }
        
        RandomNode original = head, copy = head.next;
        RandomNode temp = copy;
        
        while (original != null) {
            original.next = original.next.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        
        return temp;
    }
    
    public static void main(String[] args) {
        CloneLinkedList list = new CloneLinkedList();
        list.head = new RandomNode(1);
        list.head.next = new RandomNode(2);
        list.head.next.next = new RandomNode(3);
        list.head.next.next.next = new RandomNode(4);
        list.head.next.next.next.next = new RandomNode(5

);
        
        list.head.random = list.head.next.next;
        list.head.next.random = list.head;
        list.head.next.next.random = list.head.next.next.next.next;
        list.head.next.next.next.random = list.head.next.next;
        list.head.next.next.next.next.random = list.head.next;
        
        RandomNode clonedHead = list.clone();
        RandomNode current = clonedHead;
        while (current != null) {
            System.out.print("Data: " + current.data + ", Random: " + (current.random != null ? current.random.data : "null") + "\n");
            current = current.next;
        }
    }
}
```

# 21. LRU Cache Design
```java
import java.util.*;

class LRUCache {
    class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;
        
        public DNode() {}
        
        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Map<Integer, DNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DNode head, tail;
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DNode node = cache.get(key);
        if (node == null) {
            DNode newNode = new DNode(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            if (size > capacity) {
                DNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    
    private void addNode(DNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(DNode node) {
        DNode prev = node.prev;
        DNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    private void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }
    
    private DNode popTail() {
        DNode res = tail.prev;
        removeNode(res);
        return res;
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
```
