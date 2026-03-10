package com.portfolio.joboffers.domain.offer;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OfferFacade {
    private final OfferAdder adder;
    private final OfferRetriever retriever;
    private final OfferFetcher fetcher;

    public Long saveOffer(OfferDto offerDto){
        return adder.addOffer(offerDto);
    }

    public List<OfferDto> findAllOffers(){
        return retriever.findAllOffers();
    }

    public OfferDto findOfferById(final Long id) {
        return retriever.findOfferById(id);
    }

    public List<OfferDto> fetchAllOffersAndSaveAllIfNotExists() {
        List<OfferDto> offersToSave = fetcher.fetchNewOffer();
        adder.saveAll(offersToSave);
        return offersToSave;
    }
}
