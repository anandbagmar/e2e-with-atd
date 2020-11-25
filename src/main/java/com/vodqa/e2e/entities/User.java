package com.vodqa.e2e.entities;

import com.vodqa.e2e.utils.Randomizer;

public final class User {
  private final String lastName;
  private final String firstName;
  private final String emailOrMobile;

  public User(String emailOrMobile, String firstName, String lastName) {
    this.emailOrMobile = Randomizer.randomize(emailOrMobile);
    this.firstName = firstName;
    this.lastName = lastName;
//    System.out.println("Creating user: " + toString());
  }

  @Override
  public String toString() {
    String format = String.format(
            "User details:\n\tEmail Or Mobile: %s\n\tFirst name: %s\n\tLast name: %s%n",
            emailOrMobile, firstName, lastName);
    return format;
  }

  public String emailOrMobile() {
    return this.emailOrMobile;
  }
}
