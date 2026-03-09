package com.portfolio.joboffers.domain.loginandregister;

class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(final String message) {
        super(message);
    }
}
