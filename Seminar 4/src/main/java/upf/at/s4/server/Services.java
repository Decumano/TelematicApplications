package upf.at.s4.server;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import upf.at.s4.data.Item;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/item")
public class Services {

    static List<Item> items = new ArrayList<>();

    static Item error404 = new Item("error 404: Item not found", 404, 1);
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Item item)
    {
        items.add(item);
        return Response.status(200).entity(item).build();
    }

    @GET
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Item get(@PathParam("name") String name)
    {
        for (Item item : items)
        {
            if(item.getName().equalsIgnoreCase(name))
            {
                return item;
            }
        }
        return error404;
    }

    @GET
    @Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> get()
    {
        return items;
    }
}