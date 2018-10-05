import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Calculator {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the JavaCalculator developed by Tristan Ross");
        String repeat = "y";
        while(repeat.equals("y")) {
            System.out.println();
            options();
            int keycode = input.nextInt();
            switch (keycode) {
                case 1: System.out.print("How many numbers would you like to add? ");
                        int count = input.nextInt();
                        BigDecimal sum = new BigDecimal(0);
                        System.out.print("Please enter the numbers separated by whitespace: ");
                        for(int i = 0; i < count; i++) {
                            sum = sum.add(new BigDecimal(input.nextDouble()).setScale(8, RoundingMode.HALF_UP));
                        }
                        printSum(sum, count);
                        break;
                        
                case 2: System.out.print("Please enter the number you would like to subtract from (subtrahend): ");
                        BigDecimal subtrahend = new BigDecimal(input.nextDouble()).setScale(8, RoundingMode.HALF_UP);
                        System.out.print("Please enter the number you would like to subtract with (minuend): ");
                        BigDecimal minuend = new BigDecimal(input.nextDouble()).setScale(8, RoundingMode.HALF_UP);
                        printDifference(subtrahend, minuend);
                        break;
                        
                case 3: System.out.print("Please enter the first factor: ");
                        BigDecimal factorOne = new BigDecimal(input.nextDouble()).setScale(8, RoundingMode.HALF_UP);
                        System.out.print("Please enter the second factor: ");
                        BigDecimal factorTwo = new BigDecimal(input.nextDouble()).setScale(8, RoundingMode.HALF_UP);
                        printProduct(factorOne, factorTwo);
                        break;
                        
                case 4: System.out.print("Please enter the dividend: ");
                        BigDecimal dividend = new BigDecimal(input.nextDouble()).setScale(8, RoundingMode.HALF_UP);
                        System.out.print("Please enter the divisor: ");
                        BigDecimal divisor = new BigDecimal(input.nextDouble()).setScale(8, RoundingMode.HALF_UP);
                        printQuotient(dividend, divisor);
                        break;
                        
                case 5: System.out.print("Please enter the divisor: ");
                        BigDecimal inverseDivisor = new BigDecimal(input.nextDouble()).setScale(8, RoundingMode.HALF_UP);
                        printReciprocal(inverseDivisor);
                        break;
                        
                case 6:
            }
            
            System.out.print("Would you like to perform another calculation? (y / n): ");
            repeat = input.next();
        }
        System.out.println("End program");
        input.close();
    }
    
    public static void options() {
        System.out.println("Addition (1)");
        System.out.println("Subtraction (2)");
        System.out.println("Multiplication (3)");
        System.out.println("Division (4)");
        System.out.println("Multiplicative Inverse (5)");
        System.out.print("Enter key to perform a calculation: ");
    }
    
    public static void printSum(BigDecimal sum, int count) {
        System.out.println("The sum of the " + count + " numbers is: " + sum.stripTrailingZeros().toPlainString());

    }
    
    public static void printDifference(BigDecimal subtrahend, BigDecimal minuend) {   
        BigDecimal difference = subtrahend.subtract(minuend);
        System.out.println(subtrahend.stripTrailingZeros().toPlainString() + " - " + minuend.stripTrailingZeros().toPlainString() + " = " + difference.stripTrailingZeros().toPlainString());
    }
    
    public static void printProduct(BigDecimal factorOne, BigDecimal factorTwo) {
        BigDecimal product = factorOne.multiply(factorTwo);
        System.out.println(factorOne.stripTrailingZeros().toPlainString() + " * " + factorTwo.stripTrailingZeros().toPlainString() + " = " + product.stripTrailingZeros().toPlainString());
    }
    
    public static void printQuotient(BigDecimal dividend, BigDecimal divisor) {
        BigDecimal quotient = dividend.divide(divisor, RoundingMode.HALF_UP);
        System.out.println(dividend.stripTrailingZeros().toPlainString() + " / " + divisor.stripTrailingZeros().toPlainString() + " = " + quotient.stripTrailingZeros().toPlainString());
    }
    
    public static void printReciprocal(BigDecimal inverseDivisor) {
        BigDecimal one = new BigDecimal(1.0).setScale(8, RoundingMode.HALF_UP);
        BigDecimal reciprocal = one.divide(inverseDivisor, RoundingMode.HALF_UP);
        System.out.println("1 / " + inverseDivisor.stripTrailingZeros().toPlainString() + " = " + reciprocal.stripTrailingZeros().toPlainString());
    }
}
