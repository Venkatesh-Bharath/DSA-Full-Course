# Module 9: Hashing

# 1. Introduction and Time complexity analysis
Hashing is a technique used to uniquely identify a specific object from a group of similar objects. The basic idea is to use a hash function to convert a given key into an index in a table. Hashing provides efficient search, insert, and delete operations with average time complexity of O(1).

# 2.  Application of Hashing
1. Dictionary data structures (e.g., sets, maps).
2. Caches.
3. Databases indexing.
4. Password storage.

# 3. Discussion on Direct Address Table
Direct Address Tables are used when the universe of keys is reasonably small. A table is created where each position corresponds to a key in the universe. Operations take constant time, O(1).

# 4. Working and examples on various Hash Functions
A hash function converts a key into an index in a hash table. Common hash functions include division method, multiplication method, and universal hashing.

# 5. Introduction and Various techniques on Collision Handling
Collisions occur when two keys hash to the same index. Techniques to handle collisions include:
- Chaining
- Open Addressing

# 6. Chaining and its implementation
In chaining, each slot in the hash table points to a linked list of entries that map to the same index.

### Java Implementation of Chaining
```java
import java.util.LinkedList;

class HashTable {
    private int BUCKET;
    private LinkedList<Integer>[] table;

    public HashTable(int b) {
        this.BUCKET = b;
        table = new LinkedList[BUCKET];
        for (int i = 0; i < BUCKET; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return key % BUCKET;
    }

    public void insertItem(int key) {
        int index = hashFunction(key);
        table[index].add(key);
    }

    public void deleteItem(int key) {
        int index = hashFunction(key);
        table[index].remove((Integer) key);
    }

    public void displayHash() {
        for (int i = 0; i < BUCKET; i++) {
            System.out.print(i);
            for (Integer key : table[i]) {
                System.out.print(" --> " + key);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 11, 27, 8, 12};
        int n = arr.length;

        HashTable h = new HashTable(7);
        for (int i = 0; i < n; i++) {
            h.insertItem(arr[i]);
        }

        h.deleteItem(12);

        h.displayHash();
    }
}
```

# 7. Open Addressing and its Implementation
Open addressing is another method for handling collisions. In this method, if a collision occurs, we probe for the next empty slot in the table.

### Java Implementation of Open Addressing
```java
class HashTableOpenAddressing {
    private int[] table;
    private int size;

    public HashTableOpenAddressing(int size) {
        this.size = size;
        table = new int[size];
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insertItem(int key) {
        int index = hashFunction(key);
        int i = 0;
        while (table[(index + i) % size] != -1) {
            i++;
        }
        table[(index + i) % size] = key;
    }

    public void deleteItem(int key) {
        int index = hashFunction(key);
        int i = 0;
        while (table[(index + i) % size] != key) {
            if (table[(index + i) % size] == -1) {
                return; // Key not found
            }
            i++;
        }
        table[(index + i) % size] = -1;
    }

    public void displayHash() {
        for (int i = 0; i < size; i++) {
            if (table[i] != -1) {
                System.out.print(table[i] + " ");
            } else {
                System.out.print("~ ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {15, 11, 27, 8, 12};
        int n = arr.length;

        HashTableOpenAddressing h = new HashTableOpenAddressing(7);
        for (int i = 0; i < n; i++) {
            h.insertItem(arr[i]);
        }

        h.deleteItem(12);

        h.displayHash();
    }
}
```

# 8. Chaining V/S Open Addressing
- **Chaining**: Uses linked lists to handle collisions. It can handle more keys than the size of the hash table but requires additional memory for linked lists.
- **Open Addressing**: Uses probing to find the next available slot. It uses the hash table more efficiently but can lead to clustering, making insertions and deletions slower.

# 9. Double Hashing
Double hashing is a technique in open addressing where we use two hash functions to calculate the probe sequence. If a collision occurs, the second hash function determines the step size for probing.

### Java Implementation of Double Hashing
```java
class HashTableDoubleHashing {
    private int[] table;
    private int size;

    public HashTableDoubleHashing(int size) {
        this.size = size;
        table = new int[size];
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    private int hashFunction1(int key) {
        return key % size;
    }

    private int hashFunction2(int key) {
        return 1 + (key % (size - 1));
    }

    public void insertItem(int key) {
        int index = hashFunction1(key);
        int i = 0;
        while (table[(index + i * hashFunction2(key)) % size] != -1) {
            i++;
        }
        table[(index + i * hashFunction2(key)) % size] = key;
    }

    public void deleteItem(int key) {
        int index = hashFunction1(key);
        int i = 0;
        while (table[(index + i * hashFunction2(key)) % size] != key) {
            if (table[(index + i * hashFunction2(key)) % size] == -1) {
                return; // Key not found
            }
            i++;
        }
        table[(index + i * hashFunction2(key)) % size] = -1;
    }

    public void displayHash() {
        for (int i = 0; i < size; i++) {
            if (table[i] != -1) {
                System.out.print(table[i] + " ");
            } else {
                System.out.print("~ ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {15, 11, 27, 8, 12};
        int n = arr.length;

        HashTableDoubleHashing h = new HashTableDoubleHashing(7);
        for (int i = 0; i < n; i++) {
            h.insertItem(arr[i]);
        }

        h.deleteItem(12);

        h.displayHash();
    }
}
```

# 11. Unordered Set
Java provides `HashSet` as an implementation of the Set interface, which uses a hash table for storage.

# 14. Example of `HashSet`
```java
import java.util.HashSet;

public class UnorderedSetExample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("cherry");

        if (set.contains("banana")) {
            System.out.println("Set contains banana");
        }

        set.remove("apple");

        for (String item : set) {
            System.out.println(item);
        }
    }
}
```

# 12. Unordered Map
Java provides `HashMap` as an implementation of the Map interface, which uses a hash table for storage.

# 13,15. Example of `HashMap`
```java
import java.util.HashMap;

public class UnorderedMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        if (map.containsKey("banana")) {
            System.out.println("Banana is present with value: " + map.get("banana"));
        }

        map.remove("apple");

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
```

# 16. Problems(With Video Solutions):

# 17. Count Distinct Elements
```java
import java.util.HashSet;

public class CountDistinctElements {
    public static int countDistinct(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        System.out.println("Count of distinct elements: " + countDistinct(arr));


    }
}
```

# 18. Count of the frequency of array elements
```java
import java.util.HashMap;

public class FrequencyOfElements {
    public static void countFrequency(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        countFrequency(arr);
    }
}
```

# 19. The intersection of two arrays
```java
import java.util.HashSet;

public class IntersectionOfArrays {
    public static void findIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        HashSet<Integer> intersection = new HashSet<>();
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 4, 5};
        System.out.print("Intersection of arrays: ");
        findIntersection(arr1, arr2);
    }
}
```

# 20. Union of two unsorted arrays
```java
import java.util.HashSet;

public class UnionOfArrays {
    public static void findUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> union = new HashSet<>();
        for (int num : arr1) {
            union.add(num);
        }
        for (int num : arr2) {
            union.add(num);
        }

        for (int num : union) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 4, 5};
        System.out.print("Union of arrays: ");
        findUnion(arr1, arr2);
    }
}
```

# 21. Pair with given sum in an unsorted array
```java
import java.util.HashSet;

public class PairWithGivenSum {
    public static void findPair(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            int complement = sum - num;
            if (set.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return;
            }
            set.add(num);
        }
        System.out.println("No pair found");
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int sum = 16;
        findPair(arr, sum);
    }
}
```

# 22. Subarray with zero-sum
```java
import java.util.HashSet;

public class SubarrayWithZeroSum {
    public static boolean hasZeroSumSubarray(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        System.out.println("Subarray with zero sum exists: " + hasZeroSumSubarray(arr));
    }
}
```

# 23. Subarray with given sum
```java
import java.util.HashMap;

public class SubarrayWithGivenSum {
    public static void findSubarray(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == sum) {
                System.out.println("Sum found between indexes 0 to " + i);
                return;
            }

            if (map.containsKey(currSum - sum)) {
                System.out.println("Sum found between indexes " + (map.get(currSum - sum) + 1) + " to " + i);
                return;
            }

            map.put(currSum, i);
        }
        System.out.println("No subarray found");
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int sum = -10;
        findSubarray(arr, sum);
    }
}
```

# 24. Longest subarray with a given sum
```java
import java.util.HashMap;

public class LongestSubarrayWithGivenSum {
    public static int longestSubarrayLength(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == sum) {
                maxLength = i + 1;
            }

            if (!map.containsKey(currSum)) {
                map.put(currSum, i);
            }

            if (map.containsKey(currSum - sum)) {
                maxLength = Math.max(maxLength, i - map.get(currSum - sum));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int sum = 15;
        System.out.println("Length of longest subarray with sum " + sum + ": " + longestSubarrayLength(arr, sum));
    }
}
```

#  25. Longest subarray with an equal number of 0’s and 1’s
```java
import java.util.HashMap;

public class LongestSubarrayEqual01 {
    public static int longestSubarrayLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += (arr[i] == 0) ? -1 : 1;

            if (currSum == 0) {
                maxLength = i + 1;
            }

            if (!map.containsKey(currSum)) {
                map.put(currSum, i);
            }

            if (map.containsKey(currSum)) {
                maxLength = Math.max(maxLength, i - map.get(currSum));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        System.out.println("Length of longest subarray with equal number of 0's and 1's: " + longestSubarrayLength(arr));
    }
}
```

# 26. Longest common span with the same sum in a binary array
```java
import java.util.HashMap;

public class LongestCommonSpanWithSameSum {
    public static int longestCommonSpan(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = arr1[i] - arr2[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            sum += diff[i];

            if (sum == 0) {
                maxLength = i + 1;
            }

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 0, 0, 0};
        int[] arr2 = {1, 0, 1, 0, 0, 1};
        System.out.println("Length of longest common span with same sum: " + longestCommonSpan(arr1, arr2));
    }
}
```

# 27. Longest Consecutive Subsequence
```java
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static int findLongestConsecutiveSubseq(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                   

 currentStreak++;
                }

                maxLength = Math.max(maxLength, currentStreak);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        System.out.println("Length of the longest consecutive subsequence: " + findLongestConsecutiveSubseq(arr));
    }
}
```

# 28. Count Distinct elements in every window
```java
import java.util.HashMap;

public class CountDistinctInEveryWindow {
    public static void countDistinct(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println("Distinct count in window 1: " + map.size());

        for (int i = k; i < arr.length; i++) {
            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            System.out.println("Distinct count in window " + (i - k + 2) + ": " + map.size());
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        countDistinct(arr, k);
    }
}
```
