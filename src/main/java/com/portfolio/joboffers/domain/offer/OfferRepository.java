package com.portfolio.joboffers.domain.offer;

import java.util.List;
import java.util.Optional;

interface OfferRepository {
    Offer save(Offer offer);

    List<Offer> findAll();

    List<Offer> saveAll(List<Offer> offers);

    Optional<Offer> findById(String id);

    Optional<Offer> findByOfferUrl(String offerUrl);

    boolean existsByUrl(String url);
}
