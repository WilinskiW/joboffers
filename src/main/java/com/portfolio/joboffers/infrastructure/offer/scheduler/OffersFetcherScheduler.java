package com.portfolio.joboffers.infrastructure.offer.scheduler;

import com.portfolio.joboffers.domain.offer.OfferFacade;
import com.portfolio.joboffers.domain.offer.dto.OfferResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class OffersFetcherScheduler {
    private static final String START_FETCHING_MESSAGE = "Fetching offers from remote service... ({})";
    private static final String ADDED_OFFERS_MESSAGE = "Added new {} offers";
    private static final String END_FETCHING_MESSAGE = "End fetching offers ({})";
    private static final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final OfferFacade facade;

    @Scheduled(fixedDelayString = "${offers.fetching.request.delay}")
    public List<OfferResponseDto> fetchNewOffers() {
        log.info(START_FETCHING_MESSAGE, dateFormat.format(new Date()));
        var offers = facade.fetchAllOffersAndSaveAllIfNotExists();
        log.info(ADDED_OFFERS_MESSAGE, offers.size());
        log.info(END_FETCHING_MESSAGE, dateFormat.format(new Date()));
        return offers;
    }
}
