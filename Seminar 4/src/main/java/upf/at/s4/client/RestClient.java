package upf.at.s4.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import upf.at.s4.data.Item;

public class RestClient {
    public static void main(String[] args) 
    {
    // Items
        Item item1 = new Item("iPhone6", 699, 10);
        Item item2 = new Item("iPhone5", 399, 500);
        Client client = ClientBuilder.newClient();
        WebTarget targetAdd = client.target("http://ec2-35-174-176-222.compute-1.amazonaws.com:8080").path("seminar4/at/item/add");
        // Add items
        Item response1 = targetAdd.request(MediaType.APPLICATION_JSON_TYPE)
        .post(Entity.entity(item1, MediaType.APPLICATION_JSON), Item.class);

        Item response2 = targetAdd.request(MediaType.APPLICATION_JSON_TYPE)
        .post(Entity.entity(item2, MediaType.APPLICATION_JSON), Item.class);

        WebTarget targetGet = client.target("http://ec2-35-174-176-222.compute-1.amazonaws.com:8080").path("seminar4/at/item/get/iPhone6");
        // Get item by name
        Item item = targetGet.request(
        MediaType.APPLICATION_JSON_TYPE).get(new GenericType<Item>() {});
        System.out.println("Item: " + item);

        WebTarget targetAll = client.target("http://ec2-35-174-176-222.compute-1.amazonaws.com:8080").path("seminar4/at/item/list");
        List<Item> items = targetAll.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<Item>>() {});
        System.out.println("Item list: " + items);
    }
}