# 1. Writing Base Cases in Recursion
Base cases in recursion are the conditions under which the recursive function stops calling itself, preventing infinite recursion and providing a solution for the simplest sub-problems.

Example:
```java
public class BaseCaseExample {
    public static void printNumbers(int n) {
        if (n == 0) {  // Base case
            return;
        }
        System.out.println(n);
        printNumbers(n - 1);  // Recursive call
    }

    public static void main(String[] args) {
        printNumbers(5);  // Prints 5, 4, 3, 2, 1
    }
}
```

# 2. Factorial
The factorial of a non-negative integer \( n \) is the product of all positive integers less than or equal to \( n \).

Example in Java:
```java
public class Factorial {
    public static int factorial(int n) {
        if (n == 0) {  // Base case
            return 1;
        }
        return n * factorial(n - 1);  // Recursive call
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));  // 120
    }
}
```

# 3. N-th Fibonacci Number
The Fibonacci sequence is a series where each number is the sum of the two preceding ones, usually starting with 0 and 1.

Example in Java:
```java
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) {  // Base cases
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);  // Recursive call
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));  // 55
    }
}
```

# 4. Various Problems on Recursion

#### Print n to 1
Example in Java:
```java
public class PrintNto1 {
    public static void printNto1(int n) {
        if (n == 0) {  // Base case
            return;
        }
        System.out.println(n);
        printNto1(n - 1);  // Recursive call
    }

    public static void main(String[] args) {
        printNto1(5);  // Prints 5, 4, 3, 2, 1
    }
}
```

# 5. Tail Recursion
Tail recursion occurs when the recursive call is the last statement in the function.

Example in Java:
```java
public class TailRecursion {
    public static void printNto1Tail(int n, int k) {
        if (n == 0) {  // Base case
            return;
        }
        System.out.println(k);
        printNto1Tail(n - 1, k + 1);  // Recursive call
    }

    public static void main(String[] args) {
        printNto1Tail(5, 1);  // Prints 1, 2, 3, 4, 5
    }
}
```

# 6. Checking Palindrome
A palindrome is a string that reads the same forward and backward.

Example in Java:
```java
public class Palindrome {
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {  // Base case
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);  // Recursive call
    }

    public static void main(String[] args) {
        String str = "radar";
        System.out.println(isPalindrome(str, 0, str.length() - 1));  // true
    }
}
```

# 7. Sum of Digits
Example in Java:
```java
public class SumOfDigits {
    public static int sumOfDigits(int n) {
        if (n == 0) {  // Base case
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);  // Recursive call
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(1234));  // 10
    }
}
```

# 8. Rod Cutting
The rod cutting problem involves cutting a rod into pieces to maximize the total value.

Example in Java:
```java
public class RodCutting {
    public static int rodCut(int[] prices, int n) {
        if (n == 0) {  // Base case
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(maxValue, prices[i - 1] + rodCut(prices, n - i));  // Recursive call
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(rodCut(prices, n));  // 22
    }
}
```

# 9. Subsets of a Set
Generate all possible subsets of a set.

Example in Java:
```java
import java.util.*;

public class Subsets {
    public static void generateSubsets(int[] set, int index, List<Integer> current) {
        if (index == set.length) {  // Base case
            System.out.println(current);
            return;
        }
        generateSubsets(set, index + 1, current);  // Exclude the element
        current.add(set[index]);
        generateSubsets(set, index + 1, current);  // Include the element
        current.remove(current.size() - 1);  // Backtrack
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        generateSubsets(set, 0, new ArrayList<>());
    }
}
```

# 10. Tower of Hanoi Problem
Move n disks from source rod to destination rod using an auxiliary rod.

Example in Java:
```java
public class TowerOfHanoi {
    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {  // Base case
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }
        solveHanoi(n - 1, fromRod, auxRod, toRod);  // Move n-1 disks from fromRod to auxRod
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);
        solveHanoi(n - 1, auxRod, toRod, fromRod);  // Move n-1 disks from auxRod to toRod
    }

    public static void main(String[] args) {
        int n = 3;  // Number of disks
        solveHanoi(n, 'A', 'C', 'B');  // A, B, C are rod names
    }
}
```

# 11. Josephus Problem
Find the position of the last person standing in a circle after every k-th person is eliminated.

Example in Java:
```java
public class JosephusProblem {
    public static int josephus(int n, int k) {
        if (n == 1) {  // Base case
            return 0;
        }
        return (josephus(n - 1, k) + k) % n;  // Recursive call
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        System.out.println(josephus(n, k));  // 3 (0-based index)
    }
}
```
