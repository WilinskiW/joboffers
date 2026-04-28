package com.portfolio.joboffers.domain.offer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class OfferConfiguration {

    @Bean
    public OfferRepository offerRepository() {
        return new OfferRepository() {
            @Override
            public Offer save(Offer offer) {
                return null;
            }

            @Override
            public List<Offer> findAll() {
                return List.of();
            }

            @Override
            public List<Offer> saveAll(List<Offer> offers) {
                return List.of();
            }

            @Override
            public Optional<Offer> findById(String id) {
                return Optional.empty();
            }

            @Override
            public Optional<Offer> findByOfferUrl(String offerUrl) {
                return Optional.empty();
            }

            @Override
            public boolean existsByUrl(String url) {
                return false;
            }
        };
    }
}
