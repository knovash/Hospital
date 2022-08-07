package root.exception;

public class NameException extends RuntimeException{

        public NameException(String message) {
            super(message);
        }

        public NameException(Throwable cause) {
            super(cause);
        }


}
