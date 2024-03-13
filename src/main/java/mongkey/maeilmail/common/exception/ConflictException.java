package mongkey.maeilmail.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(HttpStatus.CONFLICT)
public abstract class ConflictException extends ApiException {
    public ConflictException(final String message) {
        super(CONFLICT, message, null);
    }
}