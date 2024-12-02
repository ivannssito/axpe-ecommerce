package com.ivan.ecommerce.core.model.exception;

public class FilterPricesException extends InternalException {
    public FilterPricesException(String message) {
        super(message);
    }

    public FilterPricesException(Throwable cause) {
        super(cause);
    }
}
