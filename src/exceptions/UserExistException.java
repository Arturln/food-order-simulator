package exceptions;

import java.io.IOException;

public class UserExistException extends IOException {
    public UserExistException(String message) {
        super(message);
    }
}
