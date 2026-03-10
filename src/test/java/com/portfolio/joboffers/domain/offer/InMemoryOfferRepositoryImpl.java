package com.portfolio.joboffers.domain.offer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryOfferRepositoryImpl implements OfferRepository{
    private final Map<Long, Offer> db = new HashMap<>();
    private final AtomicInteger sequence_pos = new AtomicInteger(1);

    @Override
    public Long save(final Offer offer) {
        long id = sequence_pos.getAndIncrement();
        db.put(id, offer);
        return id;
    }

    @Override
    public List<Offer> findAll() {
        return db.values()
                .stream()
                .toList();
    }

    @Override
    public Optional<Offer> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public boolean existByUrl(final String url) {
        return db.values()
                .stream()
                .anyMatch(offer -> offer.offerUrl().equals(url));
    }
}
