

# Module 10: String

# 1. Discussion of String DS
Strings are sequences of characters used to store and manipulate text. They are immutable in Java, meaning once created, their values cannot be changed.

# 2. Problems(With Video Solutions)

# 3. Given a string, check if they are an anagram of each other
```java
import java.util.Arrays;

public class AnagramCheck {
    public static boolean areAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println("Are anagrams: " + areAnagram(str1, str2));
    }
}
```

# 4. Given a string, find the leftmost character that repeats
```java
public class LeftmostRepeatingCharacter {
    public static int findLeftmostRepeatingChar(String str) {
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] > 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int index = findLeftmostRepeatingChar(str);
        if (index != -1) {
            System.out.println("Leftmost repeating character is at index: " + index);
        } else {
            System.out.println("No repeating character found");
        }
    }
}
```

# 5. Given a string, find the leftmost character that does not repeat
```java
public class LeftmostNonRepeatingCharacter {
    public static int findLeftmostNonRepeatingChar(String str) {
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int index = findLeftmostNonRepeatingChar(str);
        if (index != -1) {
            System.out.println("Leftmost non-repeating character is at index: " + index);
        } else {
            System.out.println("No non-repeating character found");
        }
    }
}
```

# 6. Given a string, find the lexicographic rank of it in O(n) time
```java
public class LexicographicRank {
    public static int findLexicographicRank(String str) {
        int n = str.length();
        int mul = factorial(n);
        int rank = 1;
        int[] count = new int[256];

        for (int i = 0; i < n; i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < n; i++) {
            mul /= (n - i);
            rank += count[str.charAt(i) - 1] * mul;
            for (int j = str.charAt(i); j < 256; j++) {
                count[j]--;
            }
        }
        return rank;
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        String str = "string";
        System.out.println("Lexicographic rank of the string is: " + findLexicographicRank(str));
    }
}
```

# 7. Implementation of the previously discussed lexicographic rank problem
(Already included above)

# 8. Given a text string and a pattern string, find if a permutation of the pattern exists in the text
```java
import java.util.Arrays;

public class PermutationInText {
    public static boolean isPermutationPresent(String text, String pattern) {
        int[] countP = new int[256];
        int[] countT = new int[256];

        for (int i = 0; i < pattern.length(); i++) {
            countP[pattern.charAt(i)]++;
            countT[text.charAt(i)]++;
        }

        for (int i = pattern.length(); i < text.length(); i++) {
            if (Arrays.equals(countP, countT)) {
                return true;
            }

            countT[text.charAt(i)]++;
            countT[text.charAt(i - pattern.length())]--;
        }

        return Arrays.equals(countP, countT);
    }

    public static void main(String[] args) {
        String text = "geeksforgeeks";
        String pattern = "frog";
        System.out.println("Is permutation present: " + isPermutationPresent(text, pattern));
    }
}
```

# 9. Given two strings, check if they are rotations of each other or not
```java
public class StringRotation {
    public static boolean areRotations(String str1, String str2) {
        return (str1.length() == str2.length()) && ((str1 + str2).contains(str2));
    }

    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "CDAB";
        System.out.println("Are rotations: " + areRotations(str1, str2));
    }
}
```

# 10. Various Pattern Searching Algorithms

# 11. Rabin Karp Algorithm
```java
public class RabinKarp {
    public final static int d = 256;
    public final static int q = 101; // A prime number

    public static void search(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        for (i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + 1)) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "GEEKS FOR GEEKS";
        String pattern = "GEEK";
        search(pattern, text);
    }
}
```

# 12. KMP Algorithm
```java
public

 class KMPAlgorithm {
    public static void KMPSearch(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();

        int[] lps = new int[m];
        computeLPSArray(pattern, m, lps);

        int i = 0;
        int j = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    private static void computeLPSArray(String pattern, int m, int[] lps) {
        int length = 0;
        int i = 1;
        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = length;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPSearch(pattern, text);
    }
}
```

# * A standard string library usage
```java
public class StringLibraryUsage {
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str2 = "HELLO, WORLD!";

        System.out.println("Length of str1: " + str1.length());
        System.out.println("Character at index 1: " + str1.charAt(1));
        System.out.println("Substring from index 7 to 12: " + str1.substring(7, 12));
        System.out.println("str1 equals str2: " + str1.equals(str2));
        System.out.println("str1 equalsIgnoreCase str2: " + str1.equalsIgnoreCase(str2));
        System.out.println("Concatenation of str1 and str2: " + str1.concat(str2));
        System.out.println("Replace 'World' with 'Java': " + str1.replace("World", "Java"));
        System.out.println("Index of 'o': " + str1.indexOf('o'));
        System.out.println("Last index of 'o': " + str1.lastIndexOf('o'));
        System.out.println("Convert to lower case: " + str1.toLowerCase());
        System.out.println("Convert to upper case: " + str1.toUpperCase());
        System.out.println("Trim whitespace: " + "   Hello   ".trim());
    }
}
```
