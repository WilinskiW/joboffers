package com.portfolio.joboffers.domain.offer;

import java.util.List;

public interface OfferFetchable {
    List<OfferDto> fetch();
}
