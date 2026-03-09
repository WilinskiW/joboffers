package com.portfolio.joboffers.domain.offer;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    public void should_return_all_offers_from_database(){
        //given
        OfferFacade offerFacade = new OfferFacade(new InMemoryOfferRepositoryImpl());
        OfferDto testOffer = OfferDto.builder()
                .company("Company")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://example.com")
                .build();
        offerFacade.saveOffer(testOffer);
        offerFacade.saveOffer(testOffer);
        offerFacade.saveOffer(testOffer);
        //when
        List<OfferDto> offers = offerFacade.findAllOffers();
        //then
        assertThat(offers.size()).isEqualTo(3);
    }

    @Test
    public void should_return_offer_by_id(){
        //given
        OfferFacade offerFacade = new OfferFacade(new InMemoryOfferRepositoryImpl());
        OfferDto testOffer = OfferDto.builder()
                .company("Company")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://example.com")
                .build();
        offerFacade.saveOffer(testOffer);
        //when
        OfferDto offer = offerFacade.findOfferById(1L);
        //then
        assertThat(offer.offerUrl()).isEqualTo("https://example.com");
    }

    @Test
    public void should_throw_exception_when_offer_not_found(){
        //given
        OfferFacade offerFacade = new OfferFacade(new InMemoryOfferRepositoryImpl());
        //when & then
        assertThatThrownBy(() -> offerFacade.findOfferById(1L))
                .isInstanceOf(OfferNotFoundException.class)
                .hasMessage("Offer with id: %d not found", 1L);

    }
}