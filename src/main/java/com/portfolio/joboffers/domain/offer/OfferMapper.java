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

    static OfferDto mapOfferToOfferDto(Offer offer){
        return OfferDto.builder()
                .company(offer.company())
                .position(offer.position())
                .salary(offer.salary())
                .offerUrl(offer.offerUrl())
                .build();
    }
}
