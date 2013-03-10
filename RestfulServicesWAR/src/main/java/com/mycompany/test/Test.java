package com.mycompany.test;

import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.google.gson.Gson;
import com.mycompany.model.Friend;
import com.mycompany.service.CouchbaseClientService;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Darimireddi Chakravarthi
 */
public class Test {

  public static void main(String args[]) {
    Gson gson = new Gson();

    Friend friend = new Friend();
    friend.setId(1);
    friend.setFirstName("Darimireddi");
    friend.setLastName("Chakravarthi");
    friend.setCity("Bangalore");

    System.out.println("" + gson.toJson(friend));

    CouchbaseClientService couchbaseClientService = new CouchbaseClientService();
    View view = couchbaseClientService.getCouchbaseClient().getView("friend", "friendView");

    Query query = new Query();
    query.setIncludeDocs(true).setLimit(2);

    ViewResponse results = couchbaseClientService.getCouchbaseClient().query(view, query);
    for (ViewRow row : results) {
      System.out.println("" + gson.fromJson(row.getDocument().toString(), Friend.class));
    }
    
    System.exit(0);
  }
}