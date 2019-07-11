package com.project.yingxieg.common.entity;


public class Good {

  private int id;
  private String name;
  private int seller;
  private int price;

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public int getSeller() {
    return seller;
  }

  public void setSeller(int seller) {
    this.seller = seller;
  }

}
