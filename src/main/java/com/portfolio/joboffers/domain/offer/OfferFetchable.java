package com.portfolio.joboffers.domain.offer;

import com.portfolio.joboffers.domain.offer.dto.JobOfferResponse;

import java.util.List;

interface OfferFetchable {
    List<JobOfferResponse> fetchOffers();
}
