package com.portfolio.joboffers.domain.offer;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
class OfferFetcher {
    private OfferRepository repository;
    private final OfferFetchable client;

    public List<OfferDto> fetchNewOffer(){
        return client.fetch()
                .stream()
                .filter(offer -> !repository.existByUrl(offer.offerUrl()))
                .toList();
    }
}
