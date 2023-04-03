package sit.int204.classicmodelservice.exceptions;

public class InvalidPassword extends RuntimeException{
    public InvalidPassword(String message) {
        super(message);
    }

    public InvalidPassword(String message, Throwable cause) {
        super(message, cause);
    }
}
