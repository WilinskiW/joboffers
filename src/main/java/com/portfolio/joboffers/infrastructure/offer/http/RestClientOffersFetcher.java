package com.portfolio.joboffers.infrastructure.offer.http;

import com.portfolio.joboffers.domain.offer.OfferFetchable;
import com.portfolio.joboffers.domain.offer.dto.JobOfferResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class RestClientOffersFetcher implements OfferFetchable {

    public static final String JOB_OFFERS_SERVICE = "/offers";

    private final RestClient client;
    private final String uri;
    private final int port;

    @Override
    public List<JobOfferResponse> fetchOffers() {
        try {
            String offersUri = uri + ":" + port + JOB_OFFERS_SERVICE;
            return client.get()
                    .uri(offersUri)
                    .retrieve()
                    .onStatus(HttpStatusCode::isError, (req, res) -> {
                        log.error("External service returned error status: {}", res.getStatusCode());
                    })
                    .body(new ParameterizedTypeReference<>() {});
        } catch (Exception e) {
            log.error("Critical failure during HTTP communication: {}", e.getMessage());
            return List.of();
        }
    }
}
