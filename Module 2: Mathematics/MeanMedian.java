// 4. Mean and Median
// Explanation:

// Mean: The average of a set of numbers.
// Median: The middle value of a set of numbers when arranged in order.


import java.util.Arrays;

public class MeanMedian {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        double mean = calculateMean(numbers);
        double median = calculateMedian(numbers);
        
        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
    }

    public static double calculateMean(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }

    public static double calculateMedian(int[] numbers) {
        Arrays.sort(numbers);
        if (numbers.length % 2 == 0) {
            return (numbers[numbers.length / 2 - 1] + numbers[numbers.length / 2]) / 2.0;
        } else {
            return numbers[numbers.length / 2];
        }
    }
}
