package de.samples.javaee.richfaces.jms.sample.boundary.rest;

import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
@Singleton // pseudo-scope, not proxied as @ApplicationScoped
public class HelloController {

    @GET
    public String sayHello() {
        return "Hello World";
    }
}
