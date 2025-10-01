package tech.aesys.finale.controller;


import org.springframework.web.bind.annotation.*;
import tech.aesys.finale.service.CurrentWeatherService;
import tech.aesys.finale.service.ForecastWeatherService;
import tech.aesys.finale.swagger.model.ForecastWeather200Response;
import tech.aesys.finale.swagger.model.RealtimeWeather200Response;

@RestController("WeatherController")
@RequestMapping("/api")
public class WeatherController {

    private final CurrentWeatherService cws;
    private final ForecastWeatherService fws;

    public WeatherController(CurrentWeatherService cws, ForecastWeatherService fws) {
        this.cws = cws;
        this.fws = fws;
    }

    @GetMapping("/meteo")
    public RealtimeWeather200Response getCurrentWeather(@RequestParam(value = "city") String cityName, @RequestParam(value = "lang") String lang) {
        return cws.getCurrentWeather(cityName, lang);
    }

    @GetMapping("/previsioni")
    public ForecastWeather200Response getForecastWeather(@RequestParam(value = "city") String cityName, @RequestParam(value = "days") Integer days) {

        return fws.getForecastWeather(cityName, 4);
    }
}
