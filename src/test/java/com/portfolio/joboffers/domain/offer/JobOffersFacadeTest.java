package com.portfolio.joboffers.domain.offer;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JobOffersFacadeTest {
    @Test
    public void should_save_offer_when_url_is_unique(){
        //given
        OfferFacade offerFacade = new OfferFacade(new InMemoryOfferRepositoryImpl(), new MockOfferClientImpl());
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
    public void should_throw_exception_when_url_exist_in_database(){
        //given
        OfferFacade offerFacade = new OfferFacade(new InMemoryOfferRepositoryImpl(), new MockOfferClientImpl());
        OfferDto testOffer = OfferDto.builder()
                .company("Company")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://example.com")
                .build();
        offerFacade.saveOffer(testOffer);
        //when & then
        assertThatThrownBy(() -> offerFacade.saveOffer(testOffer))
                .isInstanceOf(OfferAlreadyExistException.class)
                .hasMessage("Offer with url: %s already exist", testOffer.offerUrl());

    }

    @Test
    public void should_return_all_offers_from_database(){
        //given
        OfferFacade offerFacade = new OfferFacade(new InMemoryOfferRepositoryImpl(), new MockOfferClientImpl());
        OfferDto testOffer = OfferDto.builder()
                .company("Test")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://example.com")
                .build();

        OfferDto testOffer2 = OfferDto.builder()
                .company("Fetcher")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://test.com")
                .build();

        OfferDto testOffer3 = OfferDto.builder()
                .company("Company32")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://example123.com")
                .build();

        offerFacade.saveOffer(testOffer);
        offerFacade.saveOffer(testOffer2);
        offerFacade.saveOffer(testOffer3);
        //when
        List<OfferDto> offers = offerFacade.findAllOffers();
        //then
        assertThat(offers.size()).isEqualTo(3);
    }

    @Test
    public void should_return_offer_by_id(){
        //given
        OfferFacade offerFacade = new OfferFacade(new InMemoryOfferRepositoryImpl(), new MockOfferClientImpl());
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
        OfferFacade offerFacade = new OfferFacade(new InMemoryOfferRepositoryImpl(), new MockOfferClientImpl());
        //when & then
        assertThatThrownBy(() -> offerFacade.findOfferById(1L))
                .isInstanceOf(OfferNotFoundException.class)
                .hasMessage("Offer with id: %d not found", 1L);
    }

    @Test
    public void should_fetch_and_save_all_offers_when_they_dont_exist(){
        //given
        OfferFacade offerFacade = new OfferFacade(new InMemoryOfferRepositoryImpl(), new MockOfferClientImpl());
        OfferDto existingOffer = OfferDto.builder()
                .company("Test")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://example.com")
                .build();
        offerFacade.saveOffer(existingOffer);
        //when
        List<OfferDto> offers = offerFacade.fetchAllOffersAndSaveAllIfNotExists();
        //then
        assertThat(offers.size()).isEqualTo(2L);
    }
}