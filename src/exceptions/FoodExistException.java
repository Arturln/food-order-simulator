package exceptions;

import java.io.IOException;

public class FoodExistException extends IOException {

    public FoodExistException(String message) {
        super(message);
    }
}
