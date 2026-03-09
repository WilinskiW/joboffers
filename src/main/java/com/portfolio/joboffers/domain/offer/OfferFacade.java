package com.portfolio.joboffers.domain.offer;

import lombok.AllArgsConstructor;

import static com.portfolio.joboffers.domain.offer.OfferMapper.*;

@AllArgsConstructor
public class OfferFacade {
    private final OfferRepository repository;

    public Long saveOffer(OfferDto offerDto){
        Offer offerToSave = mapOfferDtoToOffer(offerDto);
        return repository.save(offerToSave);
    }
}
