package root.exception.runtime;

public class DateInvalidException extends RuntimeException{

        public DateInvalidException(String message) {
            super(message);
        }

        public DateInvalidException(String message, Throwable cause) {
            super(message, cause);
        }


}
