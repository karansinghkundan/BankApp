package bankingApp;

public class AccountDoesNotExistException extends Exception {
    static final long serialVersionUID = 1L;

    public AccountDoesNotExistException(String message)
    {
        super(message);
    }

}