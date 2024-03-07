/**
 * Calculator
 */

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static String formatResult(double result) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(result);
    }

    public static void calculate(double number1, double number2, char operand) {
        double result = 0;
        switch (operand) {
            case '+':
                result = number1 + number2;
                break;

            case '-':
                result = number1 - number2;
                break;

            case '*':
                result = number1 * number2;
                break;

            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    System.out.println("Error: Division by zero!");
                    return;
                }
                break;

            default:
                System.out.println("Invalid operand!");
                return;
        }

        System.out.println(number1 + " " + operand + " " + number2 + " = " + formatResult(result));
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("**************************   Welcome to mini Calculator  **************************");
        
        try{
            System.out.print("Enter number 1: ");
            double number1= sc.nextDouble();

            System.out.print("Enter number 2: ");
            double number2= sc.nextDouble();

            System.out.print("Enter operand (*, /, +, -): ");
            char operand= sc.next().charAt(0);

            if(operand!='*' && operand!='/' && operand!='+' && operand!='-'){
                throw new InputMismatchException();
            }

            calculate(number1,number2,operand);
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input! Closing calculator!");
        }
    }
}