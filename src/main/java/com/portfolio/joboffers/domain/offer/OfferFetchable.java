package com.portfolio.joboffers.domain.offer;

import com.portfolio.joboffers.domain.offer.dto.JobOfferResponse;

import java.util.List;

public interface OfferFetchable {
    List<JobOfferResponse> fetchOffers();
}
