package tech.aesys.finale.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.aesys.finale.weather.api.feign.WeatherForecastFeignClient;
import tech.aesys.finale.weather.swagger.model.ForecastWeather200Response;


@Service
@RequiredArgsConstructor
class ForecastWeatherServiceImpl implements ForecastWeatherService{

    private final WeatherForecastFeignClient forecastFeignClient;

    @Override
    public ForecastWeather200Response getForecastWeather(String cityName, Integer days) {
        if(days == 0 || days > 14 || days == null) throw new RuntimeException("Days must be between 1 and 14");

        ResponseEntity<ForecastWeather200Response> response =  forecastFeignClient.forecastWeather(cityName, days, null, null, null, null, null, null,null);
        if(!response.getStatusCode().is2xxSuccessful()){
            throw new RuntimeException("Error fetching weather data");
        } else {
            return response.getBody();
        }
    }
}
