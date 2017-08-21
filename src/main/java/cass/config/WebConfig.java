package cass.config;


import cass.web.ApplicationRoutes;
import cass.web.CarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class WebConfig {

    @Autowired
    private CarHandler carHandler;

    @Bean
    public RouterFunction<?> routerFunction() {
        return ApplicationRoutes.routes(this.carHandler);
    }
}
