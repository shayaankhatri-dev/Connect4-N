//Import relevant modules
import java.io.*;

//Human player class that is a child class of the Player class
public class HumanPlayer extends Player {
    //Initializes the variable input and assigns the BufferedReader class inherent in Java to it.
    private BufferedReader input;

    //Constructor for the HumanPlayer class
    public HumanPlayer(Token token) {
        //super is used to call constructor/method/properties of the parent class
        super(token);
        //BufferedReader is a class which simplifies reading text from a character input stream. It is used to read text from an input soruce
        //InputStream readers reads bytes and decodes them into characters using specified character set.
        //Input is set to the new class BufferedReader with new InputStream a
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    //Method from the parent class to ask user for an input
    public String getUserInput() {
        String userInput = "";
        try {
            //The readLine method is applied to the input and if the system is successful in reading it then it is set to variable userInput
            userInput = input.readLine();
        }
        //for exceptional handling
        catch (IOException e) {
            System.out.println(e);
        }
        //Returns the userInput
        return userInput;
    }
}
