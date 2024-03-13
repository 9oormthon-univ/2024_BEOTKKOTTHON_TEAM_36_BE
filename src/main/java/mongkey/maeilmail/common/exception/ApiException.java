package mongkey.maeilmail.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class ApiException extends ResponseStatusException {
    private final boolean success;
    private final Object data;
    public ApiException(final HttpStatus code, final String message, final Object data) {
        super(code, message);
        this.success = false;
        this.data = data;
    }

}