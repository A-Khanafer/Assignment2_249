package exception;

public class MinimumWageException extends Exception {

    public MinimumWageException() {
        super("Wages must be more than 15.75");
    }

    public MinimumWageException(String message) {
        super(message);
    }
}
