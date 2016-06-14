package cz.duda.projectiba.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Created by Jan Duda on 6/14/2016.
 */
public class Application extends ResourceConfig {

    public Application(){
        register(RequestContextFilter.class);
        register(StudentServiceRest.class);
        register(JacksonFeature.class);
    }
}
