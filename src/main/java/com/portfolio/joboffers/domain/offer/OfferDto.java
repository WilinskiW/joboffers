package com.portfolio.joboffers.domain.offer;

import lombok.Builder;

@Builder
public record OfferDto(String company,
                String position,
                String salary,
                String offerUrl) {
}
