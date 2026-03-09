package com.portfolio.joboffers.domain.offer;

import lombok.AllArgsConstructor;

import java.util.List;

import static com.portfolio.joboffers.domain.offer.OfferMapper.*;

@AllArgsConstructor
public class OfferFacade {
    private final OfferRepository repository;

    public Long saveOffer(OfferDto offerDto){
        Offer offerToSave = mapOfferDtoToOffer(offerDto);
        return repository.save(offerToSave);
    }

    public List<OfferDto> findAllOffers(){
        return repository.findAll().stream()
                .map(OfferMapper::mapOfferToOfferDto)
                .toList();
    }

    public OfferDto findOfferById(final Long id) {
        Offer offer = repository.findById(id)
                .orElseThrow(() -> new OfferNotFoundException("Offer with id: " + id + " not found"));

        return mapOfferToOfferDto(offer);
    }
}
