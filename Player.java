//The puprose of the Player class is to act as a Parent class to HumanPlayer and BotPlayer class.
//With the help of Player class we can interchange between HumnanPlayer and BotPlayer with ease.
//This is an abstract class as it is used to define and enforce a protocol and a set of opertion for all the objects.
//Player class that is set to public
public abstract class Player{
    //Initialize a variable 'token' and it is set to private
    private Token token;

    //This is the constructor for the Player class
    public Player(Token token){
        //Sets the value of initialized variable token to 'token'.
        //It is written as this.token to differentiate between instance variable and current variable.
        this.token = token;
    }

    //Getter method for the Player class
    //Getter method will be implemented so the token can be accessed from other classes while protecting the information
    public Token getToken(){
        //Getter method returns the token when called upon
        return token;
    }

    //The following method is used to ask the user to input a move
    public abstract String getUserInput();
}