package com.starbuck.shop.domain;
/**
 * Created by iyubinest on 3/30/16.
 */
public class Coffee {
  private final String name;
  private final double price;
  private final String imageurl;

  public Coffee(String name, double price, String imageurl) {
    this.name = name;
    this.price = price;
    this.imageurl = imageurl;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getImageurl() {
    return imageurl;
  }
}
