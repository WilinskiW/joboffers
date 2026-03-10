package com.portfolio.joboffers.domain.offer;

import lombok.AllArgsConstructor;

import java.util.List;

import static com.portfolio.joboffers.domain.offer.OfferMapper.mapOfferToOfferDto;

@AllArgsConstructor
class OfferRetriever {
    private final OfferRepository repository;

    List<OfferDto> findAllOffers() {
        return repository.findAll().stream()
                .map(OfferMapper::mapOfferToOfferDto)
                .toList();
    }

    OfferDto findOfferById(final Long id) {
        Offer offer = repository.findById(id)
                .orElseThrow(() -> new OfferNotFoundException("Offer with id: " + id + " not found"));

        return mapOfferToOfferDto(offer);
    }
}
