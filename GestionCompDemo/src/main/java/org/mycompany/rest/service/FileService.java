package org.mycompany.rest.service;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

// START SNIPPET: example
@Path("/fileservice/")
public class FileService {
    
    @Path("/{id}")
    @PUT()
    @Consumes({ "application/xml", "text/plain",
                    "application/json" })
    @Produces({ "application/xml", "text/plain",
                    "application/json" })
    Object invoke(@PathParam("id") String id,
                    String payload) {
    	return null;
    }
}
