package com.jo2.server.weather.dto.reponse;

public record WeatherCreateResponse(
        long weatherId
) {
    public static WeatherCreateResponse from(long weatherId){
        return new WeatherCreateResponse(weatherId);
    }
}
