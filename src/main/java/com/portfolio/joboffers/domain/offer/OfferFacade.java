package com.portfolio.joboffers.domain.offer;

import lombok.AllArgsConstructor;

import java.util.List;

import static com.portfolio.joboffers.domain.offer.OfferMapper.*;

@AllArgsConstructor
public class OfferFacade {
    private final OfferRepository repository;
    private final OfferFetchable client;

    public Long saveOffer(OfferDto offerDto){
        String url = offerDto.offerUrl();
        if(repository.existByUrl(url)){
            throw new OfferAlreadyExistException("Offer with url: " + url + " already exist");
        }
        Offer offerToSave = mapOfferDtoToOffer(offerDto);
        return repository.save(offerToSave);
    }

    public List<OfferDto> findAllOffers(){
        return repository.findAll().stream()
                .map(OfferMapper::mapOfferToOfferDto)
                .toList();
    }

    public OfferDto findOfferById(final Long id) {
        Offer offer = repository.findById(id)
                .orElseThrow(() -> new OfferNotFoundException("Offer with id: " + id + " not found"));

        return mapOfferToOfferDto(offer);
    }

    public List<OfferDto> fetchAllOffersAndSaveAllIfNotExists() {
        List<OfferDto> offersToSave = client.fetch()
                .stream()
                .filter(offer -> !repository.existByUrl(offer.offerUrl()))
                .toList();
        saveAll(offersToSave);
        return offersToSave;
    }

    private void saveAll(List<OfferDto> offers){
        List<Offer> offersToSave = offers.stream()
                .map(OfferMapper::mapOfferDtoToOffer)
                .toList();

        offersToSave.forEach(repository::save);
    }
}
