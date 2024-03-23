package mongkey.maeilmail.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5502","http://localhost:3000",
                        "https://maeilmail.store/",
                        "chrome-extension://hmnaeapdihgonopbamgknldjohohglnj",
                        "chrome-extension://jemoljfpjcmfhlnfapdigipdhoapdeaj")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
        ;
    }

}
