package com.portfolio.joboffers.domain.offer;

class OfferFacadeConfiguration {
    static OfferFacade createForTest(OfferRepository repository, OfferFetchable fetchable){
        return new OfferFacade(
                new OfferAdder(repository),
                new OfferRetriever(repository),
                new OfferFetcher(repository, fetchable)
        );
    }
}
