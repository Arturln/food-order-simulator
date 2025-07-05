package exceptions;

import java.io.IOException;

public class InvalidNameException extends IOException {

    public InvalidNameException(String message) {
        super(message);
    }
}
