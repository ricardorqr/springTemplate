package com.springTemplate.repository;

import com.springTemplate.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class QuoteRepository {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    private String URI = "https://gturnquist-quoters.cfapps.io/api/random";

    public Optional<Quote> getQuote() {
        Optional<Quote> quote = Optional.ofNullable(restTemplateBuilder.build().getForEntity(URI, Quote.class).getBody());
        return quote;
    }

}
