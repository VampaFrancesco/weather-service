package tech.aesys.finale.api.feign.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.aesys.finale.api.feign.WeatherCurrentFeignClient;
import tech.aesys.finale.swagger.model.RealtimeWeather200Response;

@Service
@RequiredArgsConstructor
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    private final WeatherCurrentFeignClient weatherCurrentFeignClient;

    @Value("${weather.api.key}")
    private String key;

    @Override
    public void getCurrentWeather(String cityName) {
        ResponseEntity<RealtimeWeather200Response> response =  weatherCurrentFeignClient.realtimeWeather(cityName, "it", key);
    }

}
