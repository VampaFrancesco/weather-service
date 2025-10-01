package tech.aesys.finale.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import tech.aesys.finale.api.feign.config.WeatherFeignConfig;
import tech.aesys.finale.swagger.api.CurrentJsonApi;
import tech.aesys.finale.swagger.api.ForecastJsonApi;

@FeignClient(name = "WeatherForecastFeignClient",
        url = "${weather.api.url.current}",
        configuration = WeatherFeignConfig.class
)
public interface WeatherForecastFeignClient extends ForecastJsonApi
{
}
