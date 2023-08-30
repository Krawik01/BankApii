package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class InsufficientAccountBalanceException extends RuntimeException {

    public InsufficientAccountBalanceException(String message) {
        super(message);
    }
}

