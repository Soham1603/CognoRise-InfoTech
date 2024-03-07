import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class NumberGuessGame{

    static int maxTry=5;
    static int currentTry=0;
    static Scanner sc=new Scanner(System.in);

    public static int getRandomValue(){
        // Create instance of random class
        Random r =new Random();

        //Return random value from 0 to 100
        return r.nextInt(101);
    }

    public static void playGameUtil(int userInput,int rightAnswer,int currentTry){
        
        if(rightAnswer==userInput){
            System.out.println("You guessed the number ("+rightAnswer+") correctly in "+currentTry+" try");
            return;
        }

        if(currentTry>=maxTry){
            System.out.println("Maximum tries reached! You Lost");
            System.out.println("Correct answer: "+rightAnswer);
            return;
        }

        else{
            if(userInput<rightAnswer){
                System.out.print("Guess Higher Number: ");
            }
            else if(userInput>rightAnswer){
                System.out.print("Guess lower Number: "); 
            }
            int newInput=sc.nextInt();
            currentTry++;
            playGameUtil(newInput, rightAnswer, currentTry);
        }
    }

    public static void playGame(int userInput){
        int rightAnswer=getRandomValue();
        playGameUtil(userInput, rightAnswer, currentTry);
    }
    
    public static void main(String[] args) {

        System.out.print("Guess the number from 0 to 100 in "+maxTry+" tries: ");
        try{
            int userInput= sc.nextInt();
            currentTry++;
            playGame(userInput);
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input! Game Over ");
        }
    }
}