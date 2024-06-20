# 1. Binary Search and various associated problems

**Binary Search Explanation:**
Binary search is a classic algorithm used to search for an element in a sorted array. It works by repeatedly dividing the search interval in half. This approach allows for efficient searching with a time complexity of O(log n).

**Java Code:**
```java
public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // found the target
            } else if (nums[mid] < target) {
                left = mid + 1; // search in the right half
            } else {
                right = mid - 1; // search in the left half
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int index = binarySearch(nums, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index " + index);
        } else {
            System.out.println("Target " + target + " not found in the array");
        }
    }
}
```

# 2. Leftmost index of an element in an array

**Explanation:**
To find the leftmost index of a given element in a sorted array (where duplicates may exist), you can modify the binary search approach to continue searching in the left half when the element is found.

**Java Code:**
```java
public class LeftmostIndex {
    public static int leftmostIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid; // found the target, but continue searching in the left half
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1; // search in the right half
            } else {
                right = mid - 1; // search in the left half
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 4, 5, 6, 7, 8, 9};
        int target = 2;
        int index = leftmostIndex(nums, target);
        if (index != -1) {
            System.out.println("Leftmost index of " + target + " is " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}
```

# 3. Count of occurrences of x in sorted element

**Explanation:**
To count the occurrences of a target element in a sorted array, you can use binary search to find both the leftmost and rightmost indices of the element and calculate the count from these indices.

**Java Code:**
```java
public class CountOccurrences {
    public static int countOccurrences(int[] nums, int target) {
        int leftIndex = findLeftmostIndex(nums, target);
        if (leftIndex == -1) {
            return 0; // element not found
        }
        
        int rightIndex = findRightmostIndex(nums, target);
        return rightIndex - leftIndex + 1;
    }
    
    private static int findLeftmostIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid; // found the target, but continue searching in the left half
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1; // search in the right half
            } else {
                right = mid - 1; // search in the left half
            }
        }

        return result;
    }
    
    private static int findRightmostIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid; // found the target, but continue searching in the right half
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1; // search in the right half
            } else {
                right = mid - 1; // search in the left half
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 2;
        int count = countOccurrences(nums, target);
        System.out.println("Count of occurrences of " + target + " is " + count);
    }
}
```

# 4. Count of 1s in a binary sorted array

**Explanation:**
In a sorted binary array (where all elements are 0 or 1), you can find the count of 1s efficiently by using binary search to locate the first occurrence of 1.

**Java Code:**
```java
public class CountOnes {
    public static int countOnes(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Find the first occurrence of 1 using binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == 1) {
                // Check if it's the first occurrence of 1
                if (mid == 0 || nums[mid - 1] == 0) {
                    return nums.length - mid;
                } else {
                    right = mid - 1; // search in the left half
                }
            } else {
                left = mid + 1; // search in the right half
            }
        }

        return 0; // no 1 found
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 1, 1};
        int count = countOnes(nums);
        System.out.println("Count of 1s in the array is: " + count);
    }
}
```

# 5. Find an element in a sorted and rotated array

**Explanation:**
In a rotated sorted array (where the array is sorted but rotated at some pivot point), you can use a modified binary search approach to find an element efficiently.

**Java Code:**
```java
public class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // found the target
            }

            // Check which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // search in the left sorted half
                } else {
                    left = mid + 1; // search in the right unsorted half
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // search in the right sorted half
                } else {
                    right = mid - 1; // search in the left unsorted half
                }
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = search(nums, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index " + index);
        } else {
            System.out.println("Target " + target + " not found in the array");
        }
    }
}
```

# 6. Peak element

**Explanation:**
A peak element in an array is an element that is greater than its neighbors. To find a peak element efficiently, you can use a modified binary search approach to check elements around the middle.

**Java Code:**
```java
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums

.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid; // peak is in the left half
            } else {
                left = mid + 1; // peak is in the right half
            }
        }

        return left; // left (or right) is the peak element
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element is: " + nums[peakIndex]);
    }
}
```

# 7. Find an element in an infinite sized sorted array

**Explanation:**
Finding an element in an infinite sorted array is challenging due to the infinite size. You can use a two-pointer approach where one pointer grows exponentially to find an appropriate search range before applying binary search.

**Java Code:**
```java
public class InfiniteSortedArray {
    public static int searchInfiniteSortedArray(int[] nums, int target) {
        // Initialize left and right pointers
        int left = 0;
        int right = 1;

        // Expand right pointer exponentially until we find a range where target might be
        while (nums[right] < target) {
            left = right;
            right *= 2;
        }

        // Perform binary search in the found range
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // found the target
            } else if (nums[mid] < target) {
                left = mid + 1; // search in the right half
            } else {
                right = mid - 1; // search in the left half
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        // Assume nums is an infinite sorted array
        int[] nums = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, ...};
        int target = 9;
        int index = searchInfiniteSortedArray(nums, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index " + index);
        } else {
            System.out.println("Target " + target + " not found in the array");
        }
    }
}
```

# 8. The square root of an integer

**Explanation:**
To find the square root of an integer without using built-in functions like `Math.sqrt()`, you can use a binary search approach to converge on the square root.

**Java Code:**
```java
public class Sqrt {
    public static int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long left = 1;
        long right = x;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long midSqr = mid * mid;

            if (midSqr == x) {
                return (int) mid; // found the exact square root
            } else if (midSqr < x) {
                left = mid + 1; // search in the right half
                result = mid; // update result to the current mid (potential answer)
            } else {
                right = mid - 1; // search in the left half
            }
        }

        return (int) result; // return the floor of the square root
    }

    public static void main(String[] args) {
        int x = 16;
        int sqrtX = sqrt(x);
        System.out.println("Square root of " + x + " is: " + sqrtX);
    }
}
```

# 9. Two Pointer Approach Problems

**Explanation:**
The two-pointer technique involves initializing two pointers in the array and manipulating them to solve a problem efficiently. Examples include finding pairs in an unsorted or sorted array that sum up to a given value.

#### Example: Find pair in an unsorted array which gives sum X

**Java Code:**
```java
import java.util.*;

public class TwoPointerPairs {
    public static List<List<Integer>> findPairs(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort the array to use two-pointer technique

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[left]);
                pair.add(nums[right]);
                result.add(pair);
                left++;
                right--;
                // Skip duplicates
                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 7, 5, 9, 10};
        int target = 9;
        List<List<Integer>> pairs = findPairs(nums, target);
        System.out.println("Pairs with sum " + target + " are:");
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
}
```

# 10. Find triplet in an array which gives sum X

**Explanation:**
To find triplets in an array that sum up to a given value, you can use a similar two-pointer approach within a loop to fix one element and find the other two.

**Java Code:**
```java
import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip duplicates
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // Skip duplicates
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> triplets = threeSum(nums, target);
        System.out.println("Triplets with sum " + target + " are:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}
```

# 11. Median of two sorted arrays

**Explanation:**
To find the median of two sorted arrays efficiently, you can use a combination of binary search and partitioning to divide both arrays into two parts such that the median can be found.

**Java Code:**
```java
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is the smaller array
        }

        int leftHalfLength = (m + n + 1) / 2; // Length of left half of merged array

        int left = 0;
        int right = m;

        while (left <= right) {
            int partitionX = left + (right - left) / 2;
            int partitionY = leftHalfLength - partitionX;

            // Calculate maxLeftX, minRightX, maxLeftY, minRightY
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Found the correct partition
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            }

 else if (maxLeftX > minRightY) {
                // Move left in nums1
                right = partitionX - 1;
            } else {
                // Move right in nums1
                left = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Arrays should not be empty");
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median of the two sorted arrays is: " + median);
    }
}
```

# 12. Majority Element

**Explanation:**
A majority element in an array is an element that appears more than n/2 times (where n is the size of the array). You can find this element efficiently using Moore's Voting Algorithm, which runs in O(n) time complexity.

**Java Code:**
```java
public class MajorityElement {
    public static int findMajorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;

        // Find potential majority element using Moore's Voting Algorithm
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count = 1;
            } else if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
        }

        // Verify if majority element is indeed a majority
        count = 0;
        for (int num : nums) {
            if (num == majority) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return majority;
        } else {
            throw new IllegalArgumentException("No majority element found");
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int majorityElement = findMajorityElement(nums);
        System.out.println("Majority element is: " + majorityElement);
    }
}
```
