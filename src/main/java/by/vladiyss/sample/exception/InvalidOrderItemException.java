package by.vladiyss.sample.exception;

public class InvalidOrderItemException extends Exception{

    public InvalidOrderItemException() { }

    public InvalidOrderItemException(String message) {
        super(message);
    }

    public InvalidOrderItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOrderItemException(Throwable cause) {
        super(cause);
    }
}
