package com.portfolio.joboffers.domain.offer;

import java.util.List;

interface OfferFetchable {
    List<OfferDto> fetch();
}
