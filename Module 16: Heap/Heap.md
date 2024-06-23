# 1. Introduction & Implementation
A heap is a specialized tree-based data structure that satisfies the heap property:
- **Min Heap:** For every node `i` other than the root, `heap[parent(i)] <= heap[i]`.
- **Max Heap:** For every node `i` other than the root, `heap[parent(i)] >= heap[i]`.

#### Implementation in Java
Here's a basic implementation of a Min Heap in Java using an array representation:

```java
class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1]; // 1-based indexing
    }

    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }
        size++;
        heap[size] = value;
        int current = size;
        while (current > 1 && heap[parent(current)] > heap[current]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[1];
        heap[1] = heap[size];
        size--;
        minHeapify(1);
        return min;
    }

    private void minHeapify(int pos) {
        int left = leftChild(pos);
        int right = rightChild(pos);
        int smallest = pos;
        if (left <= size && heap[left] < heap[pos]) {
            smallest = left;
        }
        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != pos) {
            swap(pos, smallest);
            minHeapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }
}
```

# 2. Binary Heap
Binary Heap is a complete binary tree where every level, except possibly the last, is completely filled, and all nodes are as left as possible.

# 3. Insertion
Insertion in a heap involves adding a new element at the end and then maintaining the heap property by comparing the element with its parent.

# 4. Heapify and Extract
Heapify is the process of maintaining the heap property (either min or max) after removal or replacement of the root node.

# 5. Decrease Key, Delete and Build Heap
- **Decrease Key:** Decreasing the value of a key and then adjusting the heap to maintain the heap property.
- **Delete:** Removing a specified element from the heap and adjusting the heap structure.
- **Build Heap:** Building a heap from an unsorted array efficiently, typically done in O(n) time complexity.

# 6. Heap Sort
Heap Sort is a comparison-based sorting technique that uses a heap data structure to sort elements.

# 7. Priority Queue in C++
Priority Queue is an abstract data type similar to regular queue or stack data structures, but each element has a priority associated with it.

# 8. PriorityQueue in Java
Java provides PriorityQueue class that implements the queue interface using a priority heap. It allows elements to be inserted and removed according to their natural ordering or by a comparator provided at the queue's construction time.

Here’s an example of using `PriorityQueue` in Java:

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Creating a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements to the priority queue
        pq.offer(10);
        pq.offer(30);
        pq.offer(20);

        // Printing the elements of the priority queue
        System.out.println("PriorityQueue: " + pq);

        // Removing the top element from the priority queue
        System.out.println("Head of PriorityQueue: " + pq.peek());

        // Removing the top element from the priority queue
        pq.poll();

        // Printing the elements of the priority queue after removal
        System.out.println("PriorityQueue after poll operation: " + pq);
    }
}
```

# 9. Problems (With Video Solutions)
Let's look at solutions to some common problems involving heaps and priority queues in Java.

# 10. Sort K-Sorted Array
Given a k-sorted array (where each element is at most k positions away from its sorted position), sort the array efficiently.

# 11. Buy Maximum Items with Given Sum
Given prices of items and a sum, maximize the number of items that can be bought with the sum using a priority queue.

# 12. K Largest Elements
Find the k largest elements in an array using a min heap approach.

# 13. Merge K Sorted Arrays
Merge k sorted arrays into one sorted array using a min heap for efficient merging.

# 14. Median of a Stream
Compute the median of a stream of integers efficiently using two heaps (a max heap for the lower half and a min heap for the upper half).
