package com.portfolio.joboffers.domain.offer;

import lombok.Getter;

import java.util.List;

@Getter
public class OfferDuplicateException extends RuntimeException {

    private final List<String> offerUrls;

    public OfferDuplicateException(String offerUrl) {
        super(String.format("Offer with offerUrl [%s] already exists", offerUrl));
        this.offerUrls = List.of(offerUrl);
    }
}
