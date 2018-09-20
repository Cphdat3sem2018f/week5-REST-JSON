package rest;

import facade.FacadePerson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import entity.PersonDTO;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String json)
    {
        Person p = gson.fromJson(json, Person.class);
        
        fp.addPerson(p);
        
        //String json = gson.toJson(fp.getPersons());
        
        return Response.ok(json).build();
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteJson(String json)
    {
        Person p = gson.fromJson(json, Person.class);
        
        if(fp.deletePerson(p) != null)
        {
            return Response.ok(json).build();
        
        }
        else
        {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("{}").build();
        }
        
        //String json = gson.toJson(fp.getPersons());
        
    }
    
    @Path("{firstName}/{lastName}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(String json, @PathParam("firstName") String firstName, @PathParam("lastName") String lastName)
    {
        
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        
        PersonDTO pdto = fp.getPerson(person);
        
        if(pdto != null)
        {
            
           return Response.ok(gson.toJson(pdto)).build();
        }
        else
        {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("{}").build();
        }       
    }
    
}
