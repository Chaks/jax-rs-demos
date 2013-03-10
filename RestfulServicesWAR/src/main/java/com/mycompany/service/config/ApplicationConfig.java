/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.config;

import com.mycompany.service.FriendResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Darimireddi Chakravarthi
 */
@javax.ws.rs.ApplicationPath("/rest/*")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(FriendResource.class);

    return classes;
  }

  /**
   * Do not modify this method. It is automatically generated by NetBeans REST support.
   */
  private Set<Class<?>> getRestResourceClasses() {
    Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
    resources.add(com.mycompany.service.FriendResource.class);
    try {
      Class<?> jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
      resources.add(jacksonProvider);
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    return resources;
  }
}
