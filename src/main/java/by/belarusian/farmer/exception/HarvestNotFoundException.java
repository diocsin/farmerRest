package by.belarusian.farmer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HarvestNotFoundException extends RuntimeException {

    public HarvestNotFoundException() {
    }

    public HarvestNotFoundException(String message) {
        super(message);
    }
}
