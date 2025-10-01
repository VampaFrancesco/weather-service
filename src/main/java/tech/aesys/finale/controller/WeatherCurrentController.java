package tech.aesys.finale.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.aesys.finale.api.feign.WeatherCurrentFeignClient;
import tech.aesys.finale.service.CurrentWeatherService;
import tech.aesys.finale.service.CurrentWeatherServiceImpl;
import tech.aesys.finale.swagger.model.RealtimeWeather200Response;

@RestController("WeatherCurrentController")
@RequestMapping("/api")
public class WeatherCurrentController {

    private final CurrentWeatherService cws;

    public WeatherCurrentController(CurrentWeatherService cws) {
        this.cws = cws;
    }

    @GetMapping("/meteo")
    public RealtimeWeather200Response getCurrentWeather(@RequestParam(value = "city") String cityName, @RequestParam(value = "lang") String lang) {
        return cws.getCurrentWeather(cityName, lang);
    }

}
