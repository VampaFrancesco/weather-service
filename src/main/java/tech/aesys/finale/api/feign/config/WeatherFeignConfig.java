package tech.aesys.finale.api.feign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class WeatherFeignConfig {

    @Value("${weather.api.key}")
    private String key;

    @Bean
    public RequestInterceptor requestInterceptor () {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.query("key", key);
            }
        };
    }

}
