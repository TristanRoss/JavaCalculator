import java.util.Scanner;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.lang.Math;


/**
 *  JavaCalculator Project<br/>
 *  filename: Calculator.java<br/>
 *  Implements +, -, /, *, 1/x, n!, x^y, x^1/2, trig, log(x), ln(x)<br/>
 *  
 *  @author Tristan Ross, tgr1998@live.com
 *  @version 1.0
 *  @since 1.0
 *  
 */
public class Calculator {
    
    /**
     * 
     * Main's purpose is to handle input, most of object creation,
     * some calculations, and calling other functions.
     * 
     * @param args
     */
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
                        
                case 6: System.out.print("Please enter the base: ");
                        BigDecimal base = new BigDecimal(input.nextDouble()).setScale(8, RoundingMode.HALF_UP);
                        System.out.print("Please enter the exponent (integers only): ");
                        int exponent = input.nextInt();
                        printExpoProduct(base, exponent);
                        break;
                        
                case 7: System.out.print("Please enter the factorial: ");
                        int iteration = input.nextInt();
                        BigInteger factorial = calcFactorial(iteration);
                        printFactorial(factorial, iteration);
                        break;
                        
                case 8: System.out.print("Please enter the radicand: ");
                        double radicand = input.nextDouble();
                        printRoot(radicand);
                        break;
                
                case 9: System.out.print("Please enter an angle in radians: ");
                        double angle = input.nextDouble();
                        printTrig(angle);
                        break;
                          
                case 10: System.out.print("Please enter the value for a base 10 log: ");
                         double x = input.nextDouble();
                         printLogTen(x);
                         break;
                
                case 11: System.out.print("Please enter the value for a natural log: ");
                         double y = input.nextDouble();
                         printNaturalLog(y);
                         break;
                
                        
                default: System.out.println("**Invalid key**");
            }
            
            System.out.print("Would you like to perform another calculation? (y / n): ");
            repeat = input.next();
        }
        System.out.println("End program");
        input.close();
    }
    
    /**
     * 
     * 
     * Menu selector.
     */
    public static void options() {
        System.out.println("Addition (1)");
        System.out.println("Subtraction (2)");
        System.out.println("Multiplication (3)");
        System.out.println("Division (4)");
        System.out.println("Multiplicative Inverse (5)");
        System.out.println("Exponentiation (6)");
        System.out.println("Factorial (7)");
        System.out.println("Square root (8)");
        System.out.println("Trigonomtery angles (9)");
        System.out.println("Base 10 Log (10)");
        System.out.println("Natural Log (11)");
        System.out.print("Enter key to perform a calculation: ");
    }
    
    /**
     * Formats BigDecimal output for addition.
     * 
     * @param sum total summation of numbers entered
     * @param count number of numbers added
     * @see java.math.BigDecimal
     */
    public static void printSum(BigDecimal sum, int count) {
        System.out.println("The sum of the " + count + " numbers is: " + sum.stripTrailingZeros().toPlainString());
    }
    
    /**
     * Performs subtraction and formats BigDecimals
     * 
     * @param subtrahend first number in subtraction
     * @param minuend second number in subtraction
     * @see java.math.BigDecimal
     */
    public static void printDifference(BigDecimal subtrahend, BigDecimal minuend) {   
        BigDecimal difference = subtrahend.subtract(minuend);
        System.out.println(subtrahend.stripTrailingZeros().toPlainString() + " - " + minuend.stripTrailingZeros().toPlainString() + " = " + difference.stripTrailingZeros().toPlainString());
    }
    
    /**
     * Performs multiplication and formats BigDecimals
     * 
     * @param factorOne is the first factor
     * @param factorTwo is the second factor
     * @see java.math.BigDecimal
     */
    public static void printProduct(BigDecimal factorOne, BigDecimal factorTwo) {
        BigDecimal product = factorOne.multiply(factorTwo);
        System.out.println(factorOne.stripTrailingZeros().toPlainString() + " * " + factorTwo.stripTrailingZeros().toPlainString() + " = " + product.stripTrailingZeros().toPlainString());
    }
    
    /**
     * Performs division and formats BigDecimals
     * 
     * @param dividend is the numerator
     * @param divisor is the denominator
     * @see java.math.BigDecimal
     */
    public static void printQuotient(BigDecimal dividend, BigDecimal divisor) {
        BigDecimal quotient = dividend.divide(divisor, RoundingMode.HALF_UP);
        System.out.println(dividend.stripTrailingZeros().toPlainString() + " / " + divisor.stripTrailingZeros().toPlainString() + " = " + quotient.stripTrailingZeros().toPlainString());
    }
    
    /**
     * Finds reciprocal and formats BigDecimals
     * 
     * @param inverseDivisor is the denominator
     * @see java.math.BigDecimal
     */
    public static void printReciprocal(BigDecimal inverseDivisor) {
        BigDecimal one = new BigDecimal(1.0).setScale(8, RoundingMode.HALF_UP);
        BigDecimal reciprocal = one.divide(inverseDivisor, RoundingMode.HALF_UP);
        System.out.println("1 / " + inverseDivisor.stripTrailingZeros().toPlainString() + " = " + reciprocal.stripTrailingZeros().toPlainString());
    }
    
    /**
     * Performs exponentiation and formats BigDecimals
     * 
     * @param base is the base in exponent mathematics
     * @param exponent is the exponent in exponent mathematics
     * @see java.math.BigDecimal
     */
    public static void printExpoProduct(BigDecimal base, int exponent) {
        BigDecimal expoProduct = base.pow(exponent);
        System.out.println(base.stripTrailingZeros().toPlainString() + "^" + String.valueOf(exponent) + " = " + expoProduct.stripTrailingZeros().toPlainString());
    }
    
    /**
     * @param   count   the n in n!
     * @return the factorial of count
     */
    public static BigInteger calcFactorial(int count) {
        BigInteger factorial = BigInteger.ONE;
        for(BigInteger i = BigInteger.valueOf(count); i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
            factorial = factorial.multiply(i);
        }
        return factorial;
    }
    
    /**
     * Formats n! and the actual answer.
     * 
     * @param factorial the factorial of count for printing
     * @param count the inputted factorial
     */
    public static void printFactorial(BigInteger factorial, int count) {
        System.out.println(String.valueOf(count) + "!" + " = " + factorial.toString());
    }
    
    /**
     * Prints the root and radicand
     * @param radicand for the square root
     */
    public static void printRoot(double radicand) {
        double root = Math.sqrt(radicand);
        System.out.println("(" + String.valueOf(radicand) + ")^1/2 = " + String.valueOf(root));  
    }
    
    /**
     * Calculates the trig angles and formats them for printing
     * @param angle the angle in radians
     */
    public static void printTrig(double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        double tan = Math.tan(angle);
        String strAngle = String.valueOf(angle);
        System.out.println();
        System.out.println("sin(" + strAngle + ") = " + String.valueOf(sin) + " | csc(" + strAngle + ") = " + String.valueOf(1.0/sin));
        System.out.println("cos(" + strAngle + ") = " + String.valueOf(cos) + " | sec(" + strAngle + ") = " + String.valueOf(1.0/cos));
        System.out.println("tan(" + strAngle + ") = " + String.valueOf(tan) + " | cot(" + strAngle + ") = " + String.valueOf(1.0/tan));
        System.out.println();
    }
    
    /**
     * Calculates the base ten log of y and prints it out
     * @param y
     */
    public static void printLogTen(double y) {
         double tenLog = Math.log10(y);
         System.out.println("log(" + String.valueOf(y) + ") = " + String.valueOf(tenLog));
    }
    
    /**
     * Calculates the natural log of x and prints it out
     * @param x
     */
    public static void printNaturalLog(double x) {
        double naturalLog = Math.log(x);
        System.out.println("ln(" + String.valueOf(x) + ") = " + String.valueOf(naturalLog));
    }

}
