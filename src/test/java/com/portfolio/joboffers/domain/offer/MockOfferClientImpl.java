package com.portfolio.joboffers.domain.offer;

import com.portfolio.joboffers.domain.offer.dto.JobOfferResponse;

import java.util.List;

class MockOfferClientImpl implements OfferFetchable{
    List<JobOfferResponse> listOfOffers;

    MockOfferClientImpl(List<JobOfferResponse> listOfOffers) {
        this.listOfOffers = listOfOffers;
    }

    @Override
    public List<JobOfferResponse> fetchOffers() {
        return listOfOffers;
    }
}
