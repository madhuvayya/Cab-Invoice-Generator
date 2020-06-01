public class RideRepositoryException extends RuntimeException {

    enum ExceptionType{
        INVALID_USER_ID
    }
    ExceptionType type;

    public RideRepositoryException(String message,ExceptionType type) {
        super(message);
        this.type = type;
    }
}
