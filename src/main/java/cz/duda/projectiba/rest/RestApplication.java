package cz.duda.projectiba.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * @author Jan Duda
 */
public class RestApplication extends ResourceConfig {

    public RestApplication(){
        register(RequestContextFilter.class);
        register(StudentServiceRest.class);
        register(JacksonFeature.class);
    }
}
