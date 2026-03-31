package com.portfolio.joboffers;

public interface SampleJobOfferResponse {

    default String bodyWithOneOffer() {
        return """
                [
                  {
                    "title": "Junior Java Developer",
                    "company": "Connectis_",
                    "salary": "14 000 – 17 000 PLN",
                    "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-developer-connectis--warszawa"
                  }
                ]
                """.trim();
    }

    default String bodyWithTwoOffers() {
        return """
                [
                  {
                    "title": "Junior Java Developer",
                    "company": "Connectis_",
                    "salary": "14 000 – 17 000 PLN",
                    "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-developer-connectis--warszawa"
                  },
                  {
                    "title": "Junior Java Developer (f/m)",
                    "company": "Netcompany Poland",
                    "salary": "8 000 – 9 000 PLN",
                    "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-developer-f-m-netcompany-poland-warsaw"
                  }
                ]
                """.trim();
    }

    default String bodyWithThreeOffers() {
        return """
                [
                  {
                    "title": "Junior Java Developer",
                    "company": "Connectis_",
                    "salary": "14 000 – 17 000 PLN",
                    "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-developer-connectis--warszawa"
                  },
                  {
                    "title": "Junior Java Developer (f/m)",
                    "company": "Netcompany Poland",
                    "salary": "8 000 – 9 000 PLN",
                    "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-developer-f-m-netcompany-poland-warsaw"
                  },
                  {
                    "title": "Junior Backend Developer",
                    "company": "Kalamba Games",
                    "salary": "6 000 – 10 000 PLN",
                    "offerUrl": "https://nofluffjobs.com/pl/job/junior-backend-developer-kalamba-games-krakow"
                  }
                ]
                """.trim();
    }

    default String bodyWithFourOffers() {
        return """
                [
                  {
                    "title": "Junior Java Developer",
                    "company": "Connectis_",
                    "salary": "14 000 – 17 000 PLN",
                    "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-developer-connectis--warszawa"
                  },
                  {
                    "title": "Junior Java Developer (f/m)",
                    "company": "Netcompany Poland",
                    "salary": "8 000 – 9 000 PLN",
                    "offerUrl": "https://nofluffjobs.com/pl/job/junior-java-developer-f-m-netcompany-poland-warsaw"
                  },
                  {
                    "title": "Junior Backend Developer",
                    "company": "Kalamba Games",
                    "salary": "6 000 – 10 000 PLN",
                    "offerUrl": "https://nofluffjobs.com/pl/job/junior-backend-developer-kalamba-games-krakow"
                  },
                  {
                    "title": "(Not just a) Junior Software Engineer",
                    "company": "u2i",
                    "salary": "9 000 – 11 500 PLN",
                    "offerUrl": "https://nofluffjobs.com/pl/job/not-just-a-junior-software-engineer-u2i-krakow"
                  }
                ]
                """.trim();
    }

    default String bodyWithZeroOffers() {
        return "[]";
    }
}
