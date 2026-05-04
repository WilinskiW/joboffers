package com.portfolio.joboffers.domain.offer;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "offers")
@Builder
public record Offer(
        @Id
        String id,
        @Field("company")
        String company,
        @Field("position")
        String position,
        @Field("salary")
        String salary,
        @Field("url")
        @Indexed(unique = true)
        String offerUrl) {
}
