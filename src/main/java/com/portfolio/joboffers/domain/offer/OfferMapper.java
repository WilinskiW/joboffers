package com.portfolio.joboffers.domain.offer;

class OfferMapper {
    static Offer mapOfferDtoToOffer(OfferDto dto){
        return Offer.builder()
                .company(dto.company())
                .position(dto.position())
                .salary(dto.salary())
                .offerUrl(dto.offerUrl())
                .build();
    }
}
