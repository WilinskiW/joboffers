package com.portfolio.joboffers.domain.offer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OfferRepository {
    Offer save(Offer offer);

    List<Offer> findAll();

    List<Offer> saveAll(List<Offer> offers);

    Optional<Offer> findById(String id);

    Optional<Offer> findByOfferUrl(String offerUrl);

    boolean existsByUrl(String url);
}
