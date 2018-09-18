package sem3.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.User;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("resource")
public class Resource
{
    @Context
    private UriInfo uriInfo;
    @Context
    private HttpHeaders httpHeaders;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    
    public Resource()
    {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson()
    {
        return "";
    }
    
    @POST
    @Path("{username}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String json, @PathParam("username") String username, @DefaultValue("333") @QueryParam("id") int id)
    {
        System.out.println(json);
        
        System.out.println(username);
        System.out.println(id);
        
        System.out.println("" + uriInfo.getPathParameters().toString());
        System.out.println("" + uriInfo.getQueryParameters().toString());
        System.out.println("" + uriInfo.getQueryParameters().get("id").toString());
        
        //return Response.ok("{\"status\":\"ok\"}").build();
        return Response.status(Response.Status.ACCEPTED).entity("{\"status\":\"ok\"}").build();
    }
    
    @DELETE
    @Path("{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteJson(String json, @PathParam("username") String username, @QueryParam("deletiondate") String deletiondate)
    {
        System.out.println(username);
        System.out.println(deletiondate);
        
        if(username.equals("joe"))
        {
            return Response.ok().entity("{\"username\":\"" + username + "\", \"deletionname\":\"" + deletiondate + "\"}").build();
        }
        else
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(String json)
    {
        User user = gson.fromJson(json, User.class);
        
        System.out.println(user);
        
        String jsonBack = gson.toJson(user);
        
        //return Response.ok().entity(user).build();
        return Response.ok().entity(jsonBack).build();
    }
}