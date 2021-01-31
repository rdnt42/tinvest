package com.marowak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "/api/v1")
public class PortfolioController {

        @GetMapping("/portfolio")
        public Collection<String> sayHello() {
            return IntStream.range(0, 10)
                    .mapToObj(i -> "Hello number et " + i)
                    .collect(Collectors.toList());
        }

}
