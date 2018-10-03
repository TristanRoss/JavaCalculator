import java.util.Scanner;
public class Calculator {
  


    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the JavaCalculator developed by Tristan Ross");
        String repeat = "y";
        while(repeat.equals("y")) {
            options();
            int keycode = input.nextInt();
            switch (keycode) {
                case 1: System.out.print("How many numbers would you like to add? ");
                        int count = input.nextInt();
                        double sum = 0;
                        System.out.print("Please enter the numbers separated by whitespace: ");
                        for(int i = 0; i < count; i++) {
                            sum = sum + input.nextDouble();
                        }
                        printSum(sum, count);

            }
            
            System.out.print("Would you like to perform another calculation? (y / n): ");
            repeat = input.next();
        }
        System.out.println("End program");
        input.close();
    }
    
    public static void options() {
        System.out.println("Addition (1)");
        System.out.print("Enter key to perform a calculation: ");
    }
    
    public static void printSum(double sum, int count) {
        if(sum % 1 == 0) {
            int total = (int)sum;
            System.out.println("The sum of the " + count + " numbers is: " + total);
        } else {
            System.out.println("The sum of the " + count + " numbers is: " + sum);
        }
    }
}
