package com.portfolio.joboffers.domain.loginandregister;

class UsernameNotFoundException extends RuntimeException {
    UsernameNotFoundException(final String message) {
        super(message);
    }
}
