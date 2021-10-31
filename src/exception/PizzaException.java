package exception;

public class PizzaException extends Exception {
    public PizzaException() {
    }

    public PizzaException(String message) {
        super(message);
    }

    public PizzaException(Throwable cause) {
        super(cause);
    }

    public PizzaException(String message, Throwable cause) {
        super(message, cause);
    }
}
