package mongkey.maeilmail.common.exception;

import org.springframework.http.HttpStatus;


public abstract class NotFoundException extends ApiException {
    public NotFoundException(final String message) {
        super(HttpStatus.NOT_FOUND, message, null);
    }
}