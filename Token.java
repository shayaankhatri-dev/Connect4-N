//class for Token that is set to public
public class Token {
    // initialize a variable token that is a char and set to private
    private char token;

    //this is a constructor for the class Token
    public Token(char token) {
        // sets the value of initialized variable token to 'token'.
        //it is written as this.token to differentiate between instance variable and token variable.
        this.token = token;
    }

    //since the variable token is set to private, it cannot be accessed by other classes
    //getter method will be implemented token can be accessed from other classes while protecting the information
    public char getToken() {
        // token will be returned
        return token;
    }
}

