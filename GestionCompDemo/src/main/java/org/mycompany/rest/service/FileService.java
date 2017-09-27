package org.mycompany.rest.service;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// START SNIPPET: example
@Path("/fileservice/")
public class FileService {
    
    @Path("/{cliente}")
    @PUT()
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Object invoke(@PathParam("cliente") String cliente, String body) {
    	return null;
    }
}