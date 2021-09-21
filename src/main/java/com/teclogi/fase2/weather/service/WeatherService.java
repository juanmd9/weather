package com.teclogi.fase2.weather.service;

import com.teclogi.fase2.weather.model.Filter;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {
    public String getWeatherByFilter(Filter filter);
}
