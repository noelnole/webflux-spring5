package cass.web;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public interface ApplicationRoutes {
    static RouterFunction<?> routes(CarHandler carHandler) {
        return nest(path("/cars"),
                nest(accept(MediaType.APPLICATION_JSON),
                        route(GET("/{id}"), carHandler::get)
                                .andRoute(POST("/"), carHandler::save)
                                .andRoute(PUT("/"), carHandler::update)
                                .andRoute(DELETE("/{id}"), carHandler::delete)
                ));
    }
    
}
