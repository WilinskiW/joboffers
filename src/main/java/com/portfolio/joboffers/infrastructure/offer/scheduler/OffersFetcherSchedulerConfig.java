package com.portfolio.joboffers.infrastructure.offer.scheduler;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name="offers.fetching.enabled", matchIfMissing = true)
public class OffersFetcherSchedulerConfig {

}
