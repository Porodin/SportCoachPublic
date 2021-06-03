package com.sportCoach.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 09/03/2021 - 18:10
 * @project IntelliJ IDEA
 * @author Temnyakov Nikolay
 */
@RestController
@RequestMapping(path = "/api")
public class BrandController {

    @GetMapping(path = {"/brands"})
    public ResponseEntity<String> getAll(
            @RequestParam(name = "subCat") String subCat,
            @RequestParam(name = "prices") String prices
            ) {
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
