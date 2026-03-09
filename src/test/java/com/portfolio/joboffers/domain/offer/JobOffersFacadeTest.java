package com.portfolio.joboffers.domain.offer;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JobOffersFacadeTest {
    @Test
    public void should_save_offer(){
        //given
        OfferFacade offerFacade = new OfferFacade(new InMemoryOfferRepositoryImpl());
        OfferDto testOffer = OfferDto.builder()
                .company("Company")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://example.com")
                .build();
        //when
        Long savedOfferId = offerFacade.saveOffer(testOffer);
        //then
        assertThat(savedOfferId).isEqualTo(1L);
    }
}