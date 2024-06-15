// 3. Quadratic Equations
// Explanation: A quadratic equation is a second-order polynomial equation in a single variable x with the form ax^2 + bx + c = 0. The solutions can be found using the quadratic formula: x = (-b ± sqrt(b^2 - 4ac)) / 2a

public class QuadraticEquation {
    public static void main(String[] args) {
        double a = 1, b = -3, c = 2;
        solveQuadratic(a, b, c);
    }

    public static void solveQuadratic(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots are: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Root is: " + root);
        } else {
            System.out.println("Roots are imaginary.");
        }
    }
}
