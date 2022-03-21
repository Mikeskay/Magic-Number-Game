package magicnumbergame.base.engine;

public class ManagingNumbers {

    public static int generateRandomNumber(){
       
        int random = (int )(Math.random() * 101);
        
        return random;
    }

    public static boolean compareNumber(int userInput, int magicNumber){

        return userInput == magicNumber;
    }
    
}
