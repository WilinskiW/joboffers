package com.portfolio.joboffers.domain.loginandregister;

public class UsernameNotFoundException extends RuntimeException {
    UsernameNotFoundException(final String message) {
        super(message);
    }
}
