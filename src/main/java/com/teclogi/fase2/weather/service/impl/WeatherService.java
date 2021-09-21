package com.teclogi.fase2.weather.service.impl;

import com.teclogi.fase2.weather.model.Filter;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class WeatherService implements com.teclogi.fase2.weather.service.WeatherService {
    @Override
    public String getWeatherByFilter(Filter filter) {
        String USER_AGENT = "Mozilla/5.0";
        filter.setCity("Bogota");
        String api = "http://api.openweathermap.org/data/2.5/weather?q="+filter.getCity()+"&appid=1814d49f2dd7f3a9d477e486ee113895";
        if(filter.getLang()!=null){
            api+="&lang="+filter.getLang();
        }
        if(filter.getUnits()!=null){
            api+="&units="+filter.getUnits();
        }
        try {
            URL url = new URL(api);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = urlConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                return "GET request not worked";
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "AN ERROR OCCURRED, TRY AGAIN";
        }
    }
}
