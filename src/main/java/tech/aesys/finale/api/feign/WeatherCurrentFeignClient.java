package tech.aesys.finale.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import tech.aesys.finale.swagger.api.CurrentJsonApi;

@FeignClient(name = "WeatherCurrentFeignClient", url = "${weather.api.url.current}"
//        , configuration = FeignConfig.class
)
public interface WeatherCurrentFeignClient extends CurrentJsonApi
{
}
