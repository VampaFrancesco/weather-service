package tech.aesys.finale.weather.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import tech.aesys.finale.weather.api.feign.config.WeatherFeignConfig;
import tech.aesys.finale.weather.swagger.api.CurrentJsonApi;

@FeignClient(name = "WeatherCurrentFeignClient",
        url = "${weather.api.url.current}",
        configuration = WeatherFeignConfig.class
)
public interface WeatherCurrentFeignClient extends CurrentJsonApi {

}
