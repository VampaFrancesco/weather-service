package tech.aesys.finale.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.aesys.finale.weather.api.feign.WeatherCurrentFeignClient;
import tech.aesys.finale.swagger.model.RealtimeWeather200Response;

@Service("CurrentWeatherService")
@RequiredArgsConstructor
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    private final WeatherCurrentFeignClient weatherCurrentFeignClient;

    @Override
    public RealtimeWeather200Response getCurrentWeather(String cityName, String lang) {
        if(lang == null || lang.isEmpty()) lang = "it";

        ResponseEntity<RealtimeWeather200Response> response =  weatherCurrentFeignClient.realtimeWeather(cityName, lang);
        if(!response.getStatusCode().is2xxSuccessful()){
            throw new RuntimeException("Error fetching weather data");
        }
        return response.getBody();
    }

}
