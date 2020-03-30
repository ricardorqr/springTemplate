package com.springTemplate.controller;

import com.springTemplate.controller.dto.TopicDTOOutGetOne;
import com.springTemplate.model.Quote;
import com.springTemplate.model.Topic;
import com.springTemplate.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class QuoteController {

    @Autowired
    private QuoteRepository quoteRepository;

    @GetMapping(value = "/quote")
    public ResponseEntity<Quote> getQuote() {
        Optional<Quote> quote = quoteRepository.getQuote();
        if (quote.isPresent()) {
            return ResponseEntity.ok(quote.get());
        }
        return ResponseEntity.notFound().build();
    }

}
