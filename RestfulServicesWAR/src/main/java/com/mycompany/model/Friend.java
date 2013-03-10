/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darimireddi Chakravarthi
 */
@XmlRootElement (name = "Friend")
public class Friend {

  private long id;
  private String firstName;
  private String lastName;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String country;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 47 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
    hash = 47 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
    hash = 47 * hash + (this.street != null ? this.street.hashCode() : 0);
    hash = 47 * hash + (this.city != null ? this.city.hashCode() : 0);
    hash = 47 * hash + (this.state != null ? this.state.hashCode() : 0);
    hash = 47 * hash + (this.zip != null ? this.zip.hashCode() : 0);
    hash = 47 * hash + (this.country != null ? this.country.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Friend other = (Friend) obj;
    if (this.id != other.id) {
      return false;
    }
    if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
      return false;
    }
    if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
      return false;
    }
    if ((this.street == null) ? (other.street != null) : !this.street.equals(other.street)) {
      return false;
    }
    if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city)) {
      return false;
    }
    if ((this.state == null) ? (other.state != null) : !this.state.equals(other.state)) {
      return false;
    }
    if ((this.zip == null) ? (other.zip != null) : !this.zip.equals(other.zip)) {
      return false;
    }
    if ((this.country == null) ? (other.country != null) : !this.country.equals(other.country)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Friend [");
    builder.append("city=");
    builder.append(city);
    builder.append(", country=");
    builder.append(country);
    builder.append(", firstName=");
    builder.append(firstName);
    builder.append(", id=");
    builder.append(id);
    builder.append(", lastName=");
    builder.append(lastName);
    builder.append(", state=");
    builder.append(state);
    builder.append(", street=");
    builder.append(street);
    builder.append(", zip=");
    builder.append(zip);
    builder.append("]");
    return builder.toString();
  }
}
