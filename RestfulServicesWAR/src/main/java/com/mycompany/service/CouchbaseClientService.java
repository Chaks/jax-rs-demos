/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.couchbase.client.CouchbaseClient;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Singleton;

/**
 *
 * @author Darimireddi Chakravarthi
 */
@Singleton
public class CouchbaseClientService {

  private static CouchbaseClient couchbaseClient;

  public CouchbaseClientService() {
    List<URI> nodes = new ArrayList<URI>();
    nodes.add(URI.create("http://127.0.0.1:8091/pools"));
    try {
      couchbaseClient = new CouchbaseClient(nodes, "friend", "friend");
    } catch (IOException ex) {
      Logger.getLogger(CouchbaseClientService.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public CouchbaseClient getCouchbaseClient() {
    return couchbaseClient;
  }
}
