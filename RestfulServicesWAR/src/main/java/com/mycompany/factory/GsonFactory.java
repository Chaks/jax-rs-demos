/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factory;

import com.google.gson.Gson;
import javax.enterprise.inject.Produces;

/**
 *
 * @author dchakr
 */
public class GsonFactory {

  @Produces
  public Gson getGson() {
    return new Gson();
  }
}