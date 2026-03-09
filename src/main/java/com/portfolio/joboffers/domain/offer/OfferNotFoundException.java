package com.portfolio.joboffers.domain.offer;

public class OfferNotFoundException extends RuntimeException {
    public OfferNotFoundException(String message) {
        super(message);
    }
}
