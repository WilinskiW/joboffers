package com.portfolio.joboffers.infrastructure.offer;

import com.portfolio.joboffers.domain.offer.OfferFetchable;
import com.portfolio.joboffers.domain.offer.dto.JobOfferResponse;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;

@AllArgsConstructor
public class RestClientOffersFetcher implements OfferFetchable {

    public static final String JOB_OFFERS_SERVICE = "/offers";

    private final RestClient client;
    private final String uri;
    private final int port;

    @Override
    public List<JobOfferResponse> fetchOffers() {
        String offersUri = uri + ":" + port + JOB_OFFERS_SERVICE;

        return client.get()
                .uri(offersUri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}
