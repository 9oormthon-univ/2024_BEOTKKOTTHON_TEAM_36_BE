package mongkey.maeilmail.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public abstract class ForbiddenException extends ApiException {
    public ForbiddenException(final String message) {
        super(HttpStatus.FORBIDDEN, message, null);
    }
}