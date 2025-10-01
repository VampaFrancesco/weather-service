package tech.aesys.finale.weather.service;


import tech.aesys.finale.swagger.model.ForecastWeather200Response;

public interface ForecastWeatherService {

    ForecastWeather200Response getForecastWeather(String cityName, Integer days);

}
