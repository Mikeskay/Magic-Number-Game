package magicnumbergame.base.engine;

import java.util.Scanner;
import magicnumbergame.base.engine.ManagingNumbers;

public class MagicNumberGame {


    public static void MagicNumberGame(){

        Scanner reader = new Scanner(System.in);
        int magicNumber = ManagingNumbers.generateRandomNumber();

        try {
            System.out.print("Guess the Magic number between 0 - 100:"); 
            int guess = reader.nextInt();
            System.out.println(magicNumber);

            boolean a = ManagingNumbers.compareNumber(guess, magicNumber);
            
            int counter = 1;
            
        if (a){      
            System.out.println(":) wow :0 you must have cheated! you got it right on your first go" ) ;

           }
            while (a != true){
                if (counter == 7){
                    System.out.println(" You lose!! it took you: " + counter + " times");
                    break;

                }

                if (guess > magicNumber){

                    System.out.println(" :( Incorrect guess, you went too high. you have " + (7 - counter) + " tries remaining ");
                    guess = reader.nextInt();
                }
                else if (guess < magicNumber){

                    System.out.println(" :( Incorrect guess, you went too low. you have " + (7 - counter) + " tries remaining ");
                    guess = reader.nextInt();
                }
                else {
                    
                    System.out.println(":) finally got there! it took you: " + counter + " times" ) ;
                    break;
                }  

                counter++;
            } 
            
        } catch (Exception e) {
                System.out.println("Invalid input: This value is not a number");
        }


    }
    
}
