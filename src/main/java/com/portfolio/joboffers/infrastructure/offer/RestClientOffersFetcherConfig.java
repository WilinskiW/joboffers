package com.portfolio.joboffers.infrastructure.offer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
@AllArgsConstructor
public class RestClientOffersFetcherConfig {

    @Bean
    public RestClientResponseErrorHandler restClientResponseErrorHandler() {
        return new RestClientResponseErrorHandler();
    }

    @Bean
    public RestClient restClient(@Value("${http.client.config.connectTimeout}") int connectTimeout,
                                 @Value("${http.client.config.readTimeout}") int readTimeout,
                                 RestClientResponseErrorHandler restClientResponseErrorHandler) {

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(connectTimeout);
        requestFactory.setConnectTimeout(readTimeout);

        return RestClient.builder()
                .requestFactory(requestFactory)
                .defaultStatusHandler(restClientResponseErrorHandler)
                .build();
    }

    @Bean
    public RestClientOffersFetcher restClientOffersFetcher(RestClient restClient,
                                                           @Value("${http.client.config.uri}") String baseUrl,
                                                           @Value("${http.client.config.port}") int port
    ) {
        return new RestClientOffersFetcher(restClient, baseUrl, port);
    }

}
