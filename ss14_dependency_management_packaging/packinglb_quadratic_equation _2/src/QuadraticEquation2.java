

public class QuadraticEquation2 {
    public static void main(String[] args) {
        solveQuadraticEquation2(4,-2,-6);

    }

    public static void solveQuadraticEquation2(double a, double b, double c) {

        if (a == 0) {
            System.out.println("Phương trình đang nhập không phải bậc 2");

        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("Phương trình vô nghiệm");
            } else if (delta == 0) {
                System.out.println("Phương trình có nghiệm kép x1 = x2 = " + -b / 2 * a);
            } else {
                System.out.println("Phương trình có nghiệm x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)) + " ; x2 = " + ((-b - Math.sqrt(delta))) /(2 * a));
            }
        }

    }
}
