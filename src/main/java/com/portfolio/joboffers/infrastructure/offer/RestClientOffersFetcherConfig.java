package com.portfolio.joboffers.infrastructure.offer;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
@AllArgsConstructor
public class RestClientOffersFetcherConfig {
    private final HttpClientOffersConfigurationProperties properties;

    @Bean
    public RestClientResponseErrorHandler restClientResponseErrorHandler() {
        return new RestClientResponseErrorHandler();
    }

    @Bean
    public RestClient restClient(RestClientResponseErrorHandler restClientResponseErrorHandler) {

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(properties.readTimeout());
        requestFactory.setConnectTimeout(properties.connectTimeout());

        return RestClient.builder()
                .requestFactory(requestFactory)
                .defaultStatusHandler(restClientResponseErrorHandler)
                .build();
    }

    @Bean
    public RestClientOffersFetcher restClientOffersFetcher(RestClient restClient) {
        return new RestClientOffersFetcher(restClient, properties.uri(), properties.port());
    }

}
