
# 1. Introduction and Advantages

Arrays are a collection of elements of the same type placed in contiguous memory locations. The main advantages include:
- **Fast Access**: O(1) time complexity for accessing elements by index.
- **Memory Efficiency**: No extra memory overhead for pointers or other structures.

# 2. Types of Arrays

#### Fixed-sized Array
The size of the array is specified at the time of declaration and cannot be changed.

Example in Java:
```java
int[] fixedArray = new int[5]; // Fixed-size array with 5 elements
```

#### Dynamic-sized Array
The size can change dynamically during the execution of the program, usually implemented via data structures like `ArrayList` in Java.

Example in Java:
```java
import java.util.ArrayList;
import java.util.List;

List<Integer> dynamicArray = new ArrayList<>(); // Dynamic-size array
```

# 3. Operations on Arrays

#### Searching
- **Linear Search**: O(n) time complexity.
- **Binary Search**: O(log n) time complexity, works only on sorted arrays.

Example in Java:
```java
public class Searching {
    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1; // Element not found
    }

    public static int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    }
}
```

#### Insertions
Inserting an element at a specific index in an array involves shifting elements to the right.

Example in Java:
```java
public class Insertion {
    public static int[] insertElement(int[] arr, int index, int element) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == index) {
                newArr[i] = element;
            } else {
                newArr[i] = arr[j++];
            }
        }
        return newArr;
    }
}
```

#### Deletion
Deleting an element at a specific index involves shifting elements to the left.

Example in Java:
```java
public class Deletion {
    public static int[] deleteElement(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }
}
```

# 4. Arrays vs Other Data Structures

- **Arrays**: Fixed size, fast access, and iteration.
- **Linked List**: Dynamic size, faster insertions and deletions.
- **ArrayList**: Dynamic array implementation in Java, combines features of both arrays and linked lists.

# 5. Reversing an Array
Reversing an array involves swapping the elements from both ends towards the center.

Example in Java:
```java
public class ReverseArray {
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);
        for (int num : arr) {
            System.out.print(num + " "); // 5 4 3 2 1
        }
    }
}
```

**Complexity**: O(n)

# 6. Left Rotation of the Array by 1
Move each element one position to the left, and the first element to the end.

Example in Java:
```java
public class LeftRotation {
    public static void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        leftRotateByOne(arr);
        for (int num : arr) {
            System.out.print(num + " "); // 2 3 4 5 1
        }
    }
}
```

# 7. Left Rotation of the Array by D Places
Rotate the array to the left by D places.

Example in Java:
```java
public class LeftRotationByD {
    public static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        d = d % n; // In case d is greater than n
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        leftRotate(arr, 2);
        for (int num : arr) {
            System.out.print(num + " "); // 3 4 5 1 2
        }
    }
}
```

# 8. Leaders in an Array
An element is a leader if it is greater than all the elements to its right.

Example in Java:
```java
public class LeadersInArray {
    public static void findLeaders(int[] arr) {
        int n = arr.length;
        int maxFromRight = arr[n - 1];
        System.out.print(maxFromRight + " "); // Rightmost element is always a leader

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                System.out.print(maxFromRight + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        findLeaders(arr); // 2 5 17
    }
}
```

# 9. Maximum Difference Problem
Find the maximum difference between two elements such that the larger element comes after the smaller element.

Example in Java:
```java
public class MaxDifference {
    public static int maxDifference(int[] arr) {
        int minElement = arr[0];
        int maxDiff = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - minElement > maxDiff) {
                maxDiff = arr[i] - minElement;
            }
            if (arr[i] < minElement) {
                minElement = arr[i];
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxDifference(arr)); // 8
    }
}
```

# 10. Stock Buy and Sell Problem
Find the maximum profit by buying and selling a stock once.

Example in Java:
```java
public class StockBuySell {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices)); // 5
    }
}
```

# 11. Trapping Rainwater Problem
Calculate the total amount of trapped rainwater between the buildings.

Example in Java:
```java
public class TrappingRainwater {
    public static int trap(int[] height) {
        if (height.length == 0) return 0;
        
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int waterTrapped = 0;

        leftMax[0] = height[0];
        for (int i = 1; i< n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height)); // 6
    }
}
```

# 12. Maximum Subarray Sum (Kadane's Algorithm)
Find the maximum sum of a contiguous subarray.

Example in Java:
```java
public class MaxSubarraySum {
    public static int maxSubArraySum(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(nums)); // 6
    }
}
```

# 13. Longest Even-Odd Subarray
Find the length of the longest subarray with alternating even and odd numbers.

Example in Java:
```java
public class LongestEvenOddSubarray {
    public static int longestEvenOddSubarray(int[] arr) {
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 14, 7, 8};
        System.out.println(longestEvenOddSubarray(arr)); // 3
    }
}
```

# 14. Maximum Circular Sum Subarray
Find the maximum sum of a circular subarray.

Example in Java:
```java
public class MaxCircularSubarraySum {
    public static int maxCircularSum(int[] arr) {
        int maxKadane = kadane(arr);
        int maxWrap = 0;

        for (int i = 0; i < arr.length; i++) {
            maxWrap += arr[i];
            arr[i] = -arr[i];
        }
        maxWrap += kadane(arr);

        return Math.max(maxWrap, maxKadane);
    }

    private static int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        System.out.println(maxCircularSum(arr)); // 22
    }
}
```

# 15. Majority Element
Find the element that appears more than n/2 times in the array.

Example in Java:
```java
public class MajorityElement {
    public static int findMajorityElement(int[] arr) {
        int count = 0, candidate = -1;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        return count > arr.length / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(findMajorityElement(arr)); // 2
    }
}
```

# 16. Minimum Consecutive Flips
Find the minimum number of consecutive flips required to make all elements in the array the same.

Example in Java:
```java
public class MinConsecutiveFlips {
    public static void minFlips(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] != arr[0]) {
                    System.out.print("From " + i + " to ");
                } else {
                    System.out.println(i - 1);
                }
            }
        }
        if (arr[arr.length - 1] != arr[0]) {
            System.out.println(arr.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0, 1};
        minFlips(arr); // From 2 to 4
    }
}
```

# 17. Sliding Window Technique
Used to solve problems involving subarrays or substrings efficiently.

Example: Finding the maximum sum of a subarray of size k.

Example in Java:
```java
public class SlidingWindow {
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1;

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxSumSubarray(arr, k)); // 15
    }
}
```

# 18. Prefix Sum Technique
Used to preprocess the array to answer range sum queries efficiently.

Example in Java:
```java
public class PrefixSum {
    public static int[] prefixSumArray(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }

    public static int rangeSum(int[] prefixSum, int l, int r) {
        if (l == 0) return prefixSum[r];
        return prefixSum[r] - prefixSum[l - 1];
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] prefixSum = prefixSumArray(arr);
        System.out.println(rangeSum(prefixSum, 1, 3)); // 90
    }
}
```

### 19. Practice Problems

Here are a few practice problems you can work on:
- Rotate an array to the right by k steps.
- Find the k-th largest element in an array.
- Merge two sorted arrays into one sorted array.
- Find the intersection of two arrays.
- Move all zeros to the end of the array.
