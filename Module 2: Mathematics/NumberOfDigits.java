// 1. Finding the Number of Digits in a Number
// Explanation: To find the number of digits in a number, you can repeatedly divide the number by 10 until it becomes 0, counting the number of divisions.
public class NumberOfDigits {
    public static void main(String[] args) {
        int number = 12345;
        int count = countDigits(number);
        System.out.println("Number of digits in " + number + ":" + count);
    }

    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
