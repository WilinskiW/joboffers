package com.portfolio.joboffers.domain.offer;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "offers")
@Builder
public record Offer(
        @Id
        String id,
        String company,
        String position,
        String salary,
        String offerUrl) {
}
