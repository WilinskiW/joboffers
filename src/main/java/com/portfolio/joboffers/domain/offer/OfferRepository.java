package com.portfolio.joboffers.domain.offer;

import java.util.List;
import java.util.Optional;

interface OfferRepository {
    Long save(Offer offer);

    List<Offer> findAll();

    Optional<Offer> findById(Long id);
}
