package exceptions;

public class NotExistUserException extends RuntimeException {
    public NotExistUserException(String message) {
        super(message);
    }
}
