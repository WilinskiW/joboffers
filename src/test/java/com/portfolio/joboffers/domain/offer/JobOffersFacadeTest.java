package com.portfolio.joboffers.domain.offer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JobOffersFacadeTest {
    private OfferFacade facade;

    @BeforeEach
    void setUp() {
        this.facade = OfferFacadeConfiguration.createForTest(new InMemoryOfferRepositoryImpl(), new MockOfferClientImpl());
    }


    @Test
    @DisplayName("Should save offers when urls are unique")
    public void should_save_offers_when_urls_are_unique(){
        //given
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

        //when
        Long savedOfferId = facade.saveOffer(testOffer);
        Long savedOfferId2 = facade.saveOffer(testOffer2);
        //then
        assertThat(facade.findOfferById(savedOfferId).offerUrl()).isEqualTo(testOffer.offerUrl());
        assertThat(facade.findOfferById(savedOfferId2).offerUrl()).isEqualTo(testOffer2.offerUrl());
    }

    @Test
    @DisplayName("Should throw duplicate key exception when with offer url exists")
    public void should_throw_duplicate_key_exception_when_with_offer_url_exists(){
        //given
        OfferDto testOffer = OfferDto.builder()
                .company("Company")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://example.com")
                .build();
        facade.saveOffer(testOffer);
        //when & then
        assertThatThrownBy(() -> facade.saveOffer(testOffer))
                .isInstanceOf(OfferDuplicateKeyException.class)
                .hasMessage("Offer with url: %s already exist", testOffer.offerUrl());

    }

    @Test
    @DisplayName("Should save 3 offers when there are no offers in database")
    public void should_save_3_offers_when_there_are_no_offers_in_database(){
        //given
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

        facade.saveOffer(testOffer);
        facade.saveOffer(testOffer2);
        facade.saveOffer(testOffer3);
        //when
        List<OfferDto> offers = facade.findAllOffers();
        //then
        assertThat(offers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Should find offer by id when offer was saved")
    public void should_find_offer_by_id_when_offer_was_saved(){
        //given
        OfferDto testOffer = OfferDto.builder()
                .company("Company")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://example.com")
                .build();
        facade.saveOffer(testOffer);
        //when
        OfferDto offer = facade.findOfferById(1L);
        //then
        assertThat(offer.offerUrl()).isEqualTo("https://example.com");
    }

    @Test
    @DisplayName("Should throw exception when offer not found")
    public void should_throw_exception_when_offer_not_found(){
        //given
        //when & then
        assertThatThrownBy(() -> facade.findOfferById(1L))
                .isInstanceOf(OfferNotFoundException.class)
                .hasMessage("Offer with id: %d not found", 1L);
    }

    @Test
    @DisplayName("Should fetch and save all offers when they don't exist in repository")
    public void should_fetch_and_save_all_offers_when_they_dont_exist_in_repository(){
        //given
        OfferDto existingOffer = OfferDto.builder()
                .company("Test")
                .position("Dev")
                .salary("10000-15000")
                .offerUrl("https://example.com")
                .build();
        facade.saveOffer(existingOffer);
        //when
        List<OfferDto> offers = facade.fetchAllOffersAndSaveAllIfNotExists();
        //then
        assertThat(offers.size()).isEqualTo(2L);
    }
}