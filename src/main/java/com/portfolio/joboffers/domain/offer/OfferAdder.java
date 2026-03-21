package com.portfolio.joboffers.domain.offer;

import lombok.AllArgsConstructor;

import java.util.List;

import static com.portfolio.joboffers.domain.offer.OfferMapper.mapOfferDtoToOffer;

@AllArgsConstructor
class OfferAdder {
    private final OfferRepository repository;

    Long addOffer(OfferDto offerDto) {
        String url = offerDto.offerUrl();
        if (repository.existByUrl(url)) {
            throw new OfferDuplicateKeyException("Offer with url: " + url + " already exist");
        }
        Offer offerToSave = mapOfferDtoToOffer(offerDto);
        return repository.save(offerToSave);
    }

    void saveAll(List<OfferDto> offers) {
        List<Offer> offersToSave = offers.stream()
                .map(OfferMapper::mapOfferDtoToOffer)
                .toList();

        offersToSave.forEach(repository::save);
    }
}
