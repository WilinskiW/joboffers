package com.portfolio.joboffers.domain.offer;

import lombok.Builder;

@Builder
record Offer(Long id,
             String company,
             String position,
             String salary,
             String offerUrl) {
}
