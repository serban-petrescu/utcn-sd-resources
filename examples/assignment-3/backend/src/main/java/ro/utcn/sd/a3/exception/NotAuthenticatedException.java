package ro.utcn.sd.a3.exception;

public class NotAuthenticatedException extends RuntimeException {
    public NotAuthenticatedException() {
        super("Not authenticated.");
    }
}
