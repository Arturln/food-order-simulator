package exceptions;

import java.io.IOException;

public class InvalidNumberException extends IOException {

    public InvalidNumberException(String message) {
        super(message);
    }
}
