package com.portfolio.joboffers.domain.offer;

public class OfferDuplicateKeyException extends RuntimeException {
    public OfferDuplicateKeyException(String message) {
        super(message);
    }
}
