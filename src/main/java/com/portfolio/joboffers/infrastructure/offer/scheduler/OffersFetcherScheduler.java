package com.portfolio.joboffers.infrastructure.offer.scheduler;

import com.portfolio.joboffers.domain.offer.OfferFacade;
import com.portfolio.joboffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class OffersFetcherScheduler {
    private final OfferFacade facade;

    @Scheduled(cron = "${offers.fetching.cron}")
    public List<OfferResponseDto> fetchOffers() {
        log.info("Fetching offers from remote service...");
        var offers = facade.fetchAllOffersAndSaveAllIfNotExists();
        log.info(Arrays.toString(offers.toArray()));
        log.info("Offers fetched successfully");
        return offers;
    }
}
