package tech.aesys.finale.weather.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import tech.aesys.finale.weather.api.feign.config.WeatherFeignConfig;
import tech.aesys.finale.weather.swagger.api.ForecastJsonApi;

@FeignClient(name = "WeatherForecastFeignClient",
        url = "${weather.api.url.forecast}",
        configuration = WeatherFeignConfig.class
)
public interface WeatherForecastFeignClient extends ForecastJsonApi
{
}
