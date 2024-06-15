
// 5. Prime Numbers
// Explanation: A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.public class PrimeNumbers {
     public static void main(String[] args) {
        int number = 29;
        boolean isPrime = isPrime(number);
        System.out.println(number + " is prime: " + isPrime);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
