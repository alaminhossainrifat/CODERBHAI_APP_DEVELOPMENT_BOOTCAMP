import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        
        double result;
        
        if (operator == '+') {
            result = num1 + num2;
            System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
        }
        else if (operator == '-') {
            result = num1 - num2;
            System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
        }
        else if (operator == '*') {
            result = num1 * num2;
            System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
        }
        else if (operator == '/') {
            if (num2 == 0) {
                System.out.println("Error: Cannot divide by zero!");
            } else {
                result = (double) num1 / num2;
                System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
            }
        }
        else {
            System.out.println("Invalid operator! Please use +, -, *, or /");
        }
        scanner.close();
    }
}
