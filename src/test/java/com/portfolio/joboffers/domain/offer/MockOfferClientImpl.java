package com.portfolio.joboffers.domain.offer;

import java.util.List;

public class MockOfferClientImpl implements OfferFetchable{
    @Override
    public List<OfferDto> fetch() {
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

        return List.of(testOffer, testOffer2, testOffer3);
    }
}
