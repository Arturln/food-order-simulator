package exceptions;

import java.io.IOException;

public class ExistUserException extends IOException {
    public ExistUserException(String message) {
        super(message);
    }
}
