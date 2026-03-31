package com.portfolio.joboffers.infrastructure.offer;

import lombok.Builder;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "http.client.config")
@Builder
public record HttpClientOffersConfigurationProperties(String uri, int port, int connectTimeout, int readTimeout) {

}
