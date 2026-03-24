package com.portfolio.joboffers.domain.offer;

import com.portfolio.joboffers.domain.offer.dto.JobOfferResponse;

import java.util.List;

public class OfferFacadeTestConfiguration {

    private final OfferFetchable inMemoryFetcherTest;
    private final OfferRepository offerRepository;

    OfferFacadeTestConfiguration() {
        this.inMemoryFetcherTest = new MockOfferClientImpl(
                List.of(
                        new JobOfferResponse("id", "id", "asds", "1"),
                        new JobOfferResponse("assd", "id", "asds", "2"),
                        new JobOfferResponse("asddd", "id", "asds", "3"),
                        new JobOfferResponse("asfd", "id", "asds", "4"),
                        new JobOfferResponse("agsd", "id", "asds", "5"),
                        new JobOfferResponse("adfvsd", "id", "asds", "6")
                )
        );
        this.offerRepository = new InMemoryOfferRepositoryImpl();
    }

    OfferFacadeTestConfiguration(List<JobOfferResponse> remoteClientOffers) {
        this.inMemoryFetcherTest = new MockOfferClientImpl(remoteClientOffers);
        this.offerRepository = new InMemoryOfferRepositoryImpl();
    }

    OfferFacade offerFacadeForTests() {
        return new OfferFacade(offerRepository, new OfferService(inMemoryFetcherTest, offerRepository));
    }
}
