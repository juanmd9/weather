package com.teclogi.fase2.weather.controller;

import com.teclogi.fase2.weather.model.Filter;
import com.teclogi.fase2.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {
    @Autowired
    WeatherService ws;

    @PostMapping
    public ResponseEntity<?> findByCity(@RequestBody Filter filter) {
        try {
            return new ResponseEntity<>(ws.getWeatherByFilter(filter), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("AN ERROR OCCURRED, TRY AGAIN", HttpStatus.NOT_FOUND);
        }
    }
}
