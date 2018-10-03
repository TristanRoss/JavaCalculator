import java.util.Scanner;
public class Calculator {
  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the JavaCalculator developed by Tristan Ross");
        String repeat = "y";
        while(repeat.equals("y")) {
            
            
            System.out.print("Would you like to perform another calculation? (y / n): ");
            repeat = input.next();
        }
        System.out.println("End program");
        input.close();
    }
  
}