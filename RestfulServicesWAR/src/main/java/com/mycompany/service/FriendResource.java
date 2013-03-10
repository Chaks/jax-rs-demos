/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.google.gson.Gson;
import com.mycompany.model.Friend;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Darimireddi Chakravarthi
 */
@Path("friendresource")
public class FriendResource {

  @Inject
  CouchbaseClientService couchbaseClientService;

  @GET
  @Path("friend/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Friend getFriend(@PathParam("id") String id) {
    Gson gson = new Gson();
    String jsonString = (String) couchbaseClientService.getCouchbaseClient().get(id);
    return gson.fromJson(jsonString, Friend.class);
  }

  @GET
  @Path("friends")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Friend> getFriends() {
    List<Friend> friends = new ArrayList<Friend>();

    View view = couchbaseClientService.getCouchbaseClient().getView("friend", "friendView");

    Query query = new Query();
    query.setIncludeDocs(true);

    Gson gson = new Gson();
    ViewResponse results = couchbaseClientService.getCouchbaseClient().query(view, query);
    for (ViewRow row : results) {
      friends.add(gson.fromJson(row.getDocument().toString(), Friend.class));
    }

    return friends;
  }

  @POST
  @Path("friend")
  @Consumes(MediaType.APPLICATION_JSON)
  //@Produces(MediaType.TEXT_HTML)
  public void addFriend(Friend friend) {
    Gson gson = new Gson();
    String jsonString = gson.toJson(friend);
    couchbaseClientService.getCouchbaseClient().set(friend.getId() + "", 0, jsonString);

    //ResponseBuilder responseBuilder = Response.ok("Successfully added new friend", MediaType.TEXT_HTML);
    //return responseBuilder.build();
  }
}