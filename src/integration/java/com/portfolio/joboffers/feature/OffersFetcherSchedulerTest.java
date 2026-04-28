package com.portfolio.joboffers.feature;

import com.portfolio.joboffers.BaseIntegrationTest;
import com.portfolio.joboffers.JobOffersApplication;
import com.portfolio.joboffers.domain.offer.OfferFetchable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import java.time.Duration;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = JobOffersApplication.class, properties = "offers.fetching.enabled=true")
public class OffersFetcherSchedulerTest extends BaseIntegrationTest {

    @MockitoSpyBean
    OfferFetchable remoteOfferClient;

    @Test
    public void should_run_http_client_offers_fetching_exactly_given_times() {
        await().
                atMost(Duration.ofSeconds(2))
                .untilAsserted(() -> verify(remoteOfferClient, times(2)).fetchOffers());
    }
}
