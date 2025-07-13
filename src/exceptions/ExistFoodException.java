package exceptions;

import java.io.IOException;

public class ExistFoodException extends IOException {

    public ExistFoodException(String message) {
        super(message);
    }
}
