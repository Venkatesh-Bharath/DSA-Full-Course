# 1. Bitwise Operators in C++ and Java

#### Operation of AND, OR, XOR Operators
- **AND (&)**: Bitwise AND operation returns a 1 in each bit position if both corresponding bits of the operands are 1.
- **OR (|)**: Bitwise OR operation returns a 1 in each bit position if at least one of the corresponding bits of either operand is 1.
- **XOR (^)**: Bitwise XOR operation returns a 1 in each bit position if the corresponding bits of the operands are different.

Example in Java:
```java
public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 5;  // 0101 in binary
        int b = 3;  // 0011 in binary

        System.out.println("a & b: " + (a & b)); // 0001 -> 1
        System.out.println("a | b: " + (a | b)); // 0111 -> 7
        System.out.println("a ^ b: " + (a ^ b)); // 0110 -> 6
    }
}
```

#### Operation of Left Shift, Right Shift, and Bitwise Not
- **Left Shift (<<)**: Shifts bits to the left and fills the rightmost bits with 0s.
- **Right Shift (>>)**: Shifts bits to the right and fills the leftmost bits with the sign bit (for signed numbers).
- **Unsigned Right Shift (>>>)**: Shifts bits to the right and fills the leftmost bits with 0s (ignores the sign bit).
- **Bitwise Not (~)**: Inverts all the bits of the operand.

Example in Java:
```java
public class ShiftOperators {
    public static void main(String[] args) {
        int a = 5;  // 0101 in binary

        System.out.println("a << 1: " + (a << 1)); // 1010 -> 10
        System.out.println("a >> 1: " + (a >> 1)); // 0010 -> 2
        System.out.println("a >>> 1: " + (a >>> 1)); // 0010 -> 2
        System.out.println("~a: " + (~a)); // 1010 -> -6
    }
}
```

# 2. Problems with Video Solutions

#### Check if Kth Bit is Set or Not
- **Using Left Shift**: Shift 1 to the left by k positions and AND it with the number. If the result is not 0, the k-th bit is set.
- **Using Right Shift**: Shift the number to the right by k positions and AND it with 1. If the result is 1, the k-th bit is set.

Example in Java:
```java
public class KthBitCheck {
    public static boolean isKthBitSetUsingLeftShift(int num, int k) {
        return (num & (1 << k)) != 0;
    }

    public static boolean isKthBitSetUsingRightShift(int num, int k) {
        return ((num >> k) & 1) == 1;
    }

    public static void main(String[] args) {
        int num = 5; // 0101 in binary
        int k = 2;
        System.out.println(isKthBitSetUsingLeftShift(num, k)); // true
        System.out.println(isKthBitSetUsingRightShift(num, k)); // true
    }
}
```

#### Count Set Bits
- **Simple Method**: Iterate through each bit and count the number of 1s.
- **Brian Kernighan’s Algorithm**: Subtract 1 from the number and do an AND with the original number. Repeat until the number becomes 0.
- **Using Lookup Table**: Precompute the number of set bits for all possible byte values and use this table to find the set bits for larger numbers.

Example in Java:
```java
public class CountSetBits {
    // Simple Method
    public static int countSetBitsSimple(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }

    // Brian Kernighan’s Algorithm
    public static int countSetBitsBK(int num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

    // Using Lookup Table
    public static int countSetBitsLookup(int num) {
        int[] lookup = new int[256];
        for (int i = 0; i < 256; i++) {
            lookup[i] = (i & 1) + lookup[i >> 1];
        }
        int count = 0;
        while (num > 0) {
            count += lookup[num & 0xFF];
            num >>= 8;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 29; // 11101 in binary
        System.out.println(countSetBitsSimple(num)); // 4
        System.out.println(countSetBitsBK(num)); // 4
        System.out.println(countSetBitsLookup(num)); // 4
    }
}
```

# 3. Other Problems with Video Solutions

#### Check Whether a Number is a Power of 2
A number is a power of 2 if it has exactly one set bit.

Example in Java:
```java
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int num) {
        return (num > 0) && ((num & (num - 1)) == 0);
    }

    public static void main(String[] args) {
        int num = 16; // true
        System.out.println(isPowerOfTwo(num));
    }
}
```

#### Odd Occurrences in an Array
Using XOR: XOR of all elements gives us the number with odd occurrences.

Example in Java:
```java
public class OddOccurrence {
    public static int findOddOccurrence(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 3, 4, 4, 4};
        System.out.println(findOddOccurrence(arr)); // 2
    }
}
```

#### Two Numbers Having Odd Occurrences in an Array
Using XOR: XOR all elements to get the XOR of the two numbers. Find a set bit in the XOR result and use it to divide elements into two sets.

Example in Java:
```java
public class TwoOddOccurrences {
    public static int[] findTwoOddOccurrences(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }

        // Find a set bit in xor (rightmost set bit)
        int setBit = xor & ~(xor - 1);

        int x = 0, y = 0;
        for (int num : arr) {
            if ((num & setBit) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 2, 4, 7, 9, 5, 6};
        int[] result = findTwoOddOccurrences(arr);
        System.out.println(result[0] + " " + result[1]); // 5 6
    }
}
```

#### Generate Power Set Using Bitwise Operators
Each subset corresponds to a binary number where each bit represents inclusion/exclusion of an element.

Example in Java:
```java
public class PowerSet {
    public static void generatePowerSet(int[] set) {
        int n = set.length;
        int powerSetSize = (int) Math.pow(2, n);

        for (int counter = 0; counter < powerSetSize; counter++) {
            for (int j = 0; j < n; j++) {
                if ((counter & (1 << j)) != 0) {
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        generatePowerSet(set);
    }
}
```

# 4. Practice Problems
- Implement the discussed algorithms and functions.
- Solve problems using the provided methods to get hands-on practice with bitwise operators.

