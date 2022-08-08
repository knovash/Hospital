package root.exception;

public class NameReplaceException extends Exception {

    public NameReplaceException(String message) {
        super(message);
    }

    public NameReplaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
