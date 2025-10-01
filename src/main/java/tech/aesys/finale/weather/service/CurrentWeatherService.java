package tech.aesys.finale.weather.service;

import org.springframework.stereotype.Service;
import tech.aesys.finale.swagger.model.RealtimeWeather200Response;


public interface CurrentWeatherService {

    RealtimeWeather200Response getCurrentWeather(String cityName, String lang);

}
