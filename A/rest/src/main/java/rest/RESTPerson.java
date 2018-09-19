package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.FacadePerson;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
public class RESTPerson
{
    @Context
    private UriInfo context;

    Gson gson;
    FacadePerson fp = new FacadePerson(Persistence.createEntityManagerFactory("jpapu"));
    
    public RESTPerson()
    {
        gson = new GsonBuilder().setPrettyPrinting().create();
        
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson()
    {
        String json = gson.toJson(fp.getPersons());
        
        return Response.ok(json).build();
    }
}
