//Import relevant modules
import java.util.Random;

//Bot player class that is a child class of the Player class
public class ComputerPlayer extends Player {
    //Initializes the variable random and assigns the Random class inherent in Java to it.
    private Random random;

    //Constructor for the HumanPlayer class
    public ComputerPlayer(Token token) {
        //super is used to call constructor/method/properties of the parent class
        super(token);
        //the class Random is called which is set to the variable 'random'
        random = new Random();
    }

    //Method from the parent class to ask user for an input
    //In case of a BotPlayer this input will be controlled by AI.
    public String getUserInput() {
        int r = random.nextInt(7) + 1;
        String userInput = "" + r;
        return userInput;
    }
}
